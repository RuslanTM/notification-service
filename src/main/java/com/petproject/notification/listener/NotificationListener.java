package com.petproject.notification.listener;

import com.petproject.notification.dto.NotificationDto;
import com.petproject.notification.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class NotificationListener {

    private final EmailSenderService emailSenderService;

    @KafkaListener(topics = "${kafka.topic.name}")
    public void listen(NotificationDto notification) {
        log.info("Received notification request [{}] to [{}]", notification.subject(), notification.recipient());
        emailSenderService.sendEmail(notification.recipient(),
            notification.subject(), notification.message());
        log.info("Successfully sent notification [{}] to [{}]", notification.subject(), notification.recipient());
    }
}
