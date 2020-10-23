package br.com.beertech.talents.lupulo.notificationservice.mailer;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailNotificationService {

    final JavaMailSender javaMailSender;

    public void sendMail(String to, String sub, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("rodrigo.siqueira.dev@gmail.com");
        message.setTo(to);
        message.setSubject(sub);
        message.setText(text);
        javaMailSender.send(message);

    }
}
