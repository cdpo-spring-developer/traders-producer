package com.springlessons.tradersproducer.service.kafka;

import com.springlessons.tradersproducer.dto.Trader;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TraderProducer {
    private final KafkaTemplate<String, Trader> kafkaTemplate;

    public TraderProducer(KafkaTemplate<String, Trader> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public CompletableFuture<SendResult<String, Trader>> sendMessage(String topic, String key, Trader message) {
        return kafkaTemplate.send(topic, key, message);
    }
}
