package com.springlessons.tradersproducer.service.rabbit;

import com.springlessons.tradersproducer.dto.Trader;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class TraderProducerR {
    private final RabbitTemplate rabbitTemplate;

    public TraderProducerR(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String exchange, String key, Trader trader) {
        rabbitTemplate.convertAndSend(exchange, key, trader);
    }
}
