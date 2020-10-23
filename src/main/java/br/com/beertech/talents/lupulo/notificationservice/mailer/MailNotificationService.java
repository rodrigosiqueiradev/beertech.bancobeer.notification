package br.com.beertech.talents.lupulo.notificationservice.mailer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailNotificationService {

    final JavaMailSender javaMailSender;


    private String from;

    @Value("${spring.mail.from:}")
    public void setFrom(@NonNull String from) {
        this.from = from;
    }

    public void sendMail(String to, String sub, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(sub);
        message.setText(text);
        javaMailSender.send(message);

    }
}
