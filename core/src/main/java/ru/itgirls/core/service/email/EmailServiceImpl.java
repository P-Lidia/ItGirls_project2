package ru.itgirls.core.service.email;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itgirls.core.dto.user.UserRegistrationDto;
import ru.itgirls.core.entity.User;
import ru.itgirls.core.repository.UserRepository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private Map<String, Long> keysForLink = new ConcurrentHashMap<>();
    private final EmailMessage emailMessage;
    private final JavaMailSender mailSender;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void register(UserRegistrationDto userRegistrationDto) {
        String activationKey = UUID.randomUUID().toString();
        sendEmail(
                userRegistrationDto.getEmail(),
                buildRegistrationText(userRegistrationDto.getName(), activationKey)
        );
        log.info("Activation email sent to {}", userRegistrationDto.getEmail());
        keysForLink.put(activationKey, userRegistrationDto.getId());
    }

    @Override
    @Transactional
    public void activate(String activationKey) {
        if (keysForLink.containsKey(activationKey)) {
            Long userId = keysForLink.get(activationKey);
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException(
                            String.format("User not found with id: %d", userId))
                    );
            if (!user.isEnable()) {
                user.setEnable(true);
                userRepository.save(user);
                keysForLink.remove(activationKey);
                log.info("User {} successfully activated", userId);
                sendEmail(user.getEmail(), buildActivationText(user.getName()));
            } else {
                log.warn("Activation failed for user {}: invalid or expired key", userId);
            }
        }
    }

    private void sendEmail(String userEmail, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailMessage.getFrom());
        message.setTo(userEmail);
        message.setText(text);
        mailSender.send(message);
    }

    private String buildRegistrationText(String name, String activationKey) {
        return String.format(emailMessage.getRegistrationTemplate(), name, activationKey);
    }

    private String buildActivationText(String name) {
        return String.format(emailMessage.getActivationTemplate(), name);
    }
}