package ru.itgirls.core.service.email;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.itgirls.core.dto.user.UserRegistrationDto;
import ru.itgirls.core.entity.User;
import ru.itgirls.core.repository.UserRepository;

import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final Map<String, Long> keysForLink;
    private final EmailMessage emailMessage;
    private final JavaMailSender mailSender;
    private final UserRepository userRepository;

    @Override
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
    public ResponseEntity<String> activate(String activationKey) {
        if (keysForLink.containsKey(activationKey)) {
            Long userId = keysForLink.get(activationKey);
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException(
                            String.format("User not found with id: %d", userId))
                    );
            user.setEnabled(true);
            userRepository.save(user);
            keysForLink.remove(activationKey);
            log.info("User {} successfully activated", userId);
            sendEmail(user.getEmail(), buildActivationText(user.getName()));
            return ResponseEntity.ok("Account successfully activated!");
        } else {
            log.warn("Activation failed: invalid key");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Activation failed: invalid key.");
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