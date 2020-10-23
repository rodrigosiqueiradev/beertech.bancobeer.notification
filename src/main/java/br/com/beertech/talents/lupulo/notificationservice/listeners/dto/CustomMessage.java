package br.com.beertech.talents.lupulo.notificationservice.listeners.dto;

import lombok.Data;

@Data
public class CustomMessage {
    String email;
    String subject;
    String text;
}
