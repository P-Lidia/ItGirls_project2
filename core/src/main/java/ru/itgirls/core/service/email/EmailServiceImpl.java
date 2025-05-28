package ru.itgirls.core.service.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.itgirls.core.dto.UserRegistrationDto;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailMessage emailMessage;
    private final JavaMailSender mailSender;
    private final Map<String, Long> keysForLink;

    @Override
    public void register(UserRegistrationDto userDto) {
        String uuidKey = UUID.randomUUID().toString();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailMessage.getFrom());
        message.setTo(userDto.getEmail());
        message.setText(String.format(emailMessage.getTemplate(), userDto.getName(), uuidKey));
        mailSender.send(message);
        keysForLink.put(uuidKey, userDto.getId());

        //todo: можно возвращать в контроллер строку об успехе,
        // userRegistrationDto(и уже в контроллере оборачивать его в ответ)
        // или обернуть весь код в try-catch
    }

    // генерация ключа(c помощью UUID) + отправка сообщения на email юзера с
    //  ключом в ссылке + запись в мапу. Responce, что аккаунт создан.

    @Override
    public void activation() {
    }

}
