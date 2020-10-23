package br.com.beertech.talents.lupulo.notificationservice.listeners;

import br.com.beertech.talents.lupulo.notificationservice.listeners.dto.CustomMessage;
import br.com.beertech.talents.lupulo.notificationservice.mailer.MailNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationListener {

    public static final String EMAIL_NOTIFICATIION_QUEUE = "send-email";

    final MailNotificationService mailNotificationService;

    @RabbitListener(queues = NotificationListener.EMAIL_NOTIFICATIION_QUEUE)
    public void handleMessage(final CustomMessage message) {
        log.info(message.toString());
        mailNotificationService.sendMail(message.getEmail(), message.getSubject(), message.getText());

    }
}

