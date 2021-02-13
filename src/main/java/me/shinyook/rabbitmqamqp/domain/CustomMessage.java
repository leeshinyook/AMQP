package me.shinyook.rabbitmqamqp.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CustomMessage {

    private String text;
    private int priority;

    protected CustomMessage() {}

    @Builder
    public CustomMessage(String text, int priority) {
        this.text = text;
        this.priority = priority;
    }
}
