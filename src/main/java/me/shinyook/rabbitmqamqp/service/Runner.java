package me.shinyook.rabbitmqamqp.service;

import lombok.RequiredArgsConstructor;
import me.shinyook.rabbitmqamqp.domain.CustomMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private static final String topicExchange = "spring-boot-exchange";

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10000; i++) {
            CustomMessage message = CustomMessage.builder()
                    .text("This is Test Message" + i)
                    .priority(1)
                    .build();
            System.out.println("Sending Message.");
            rabbitTemplate.convertAndSend(topicExchange, "foo.bar.test", message);
        }
    }
}
