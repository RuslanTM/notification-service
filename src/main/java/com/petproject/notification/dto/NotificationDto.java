package com.petproject.notification.dto;

public record NotificationDto(
    String message,
    String subject,
    String recipient
) {

}
