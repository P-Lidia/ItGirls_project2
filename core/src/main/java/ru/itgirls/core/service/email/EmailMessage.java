package ru.itgirls.core.service.email;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class EmailMessage {

    @Value("${custom.mail.from}")
    private String from;

    @Value("${custom.mail.message-template}")
    private String template;
}