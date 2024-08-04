package com.springlessons.tradersproducer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.converter.MessageConverter;

@Configuration
public class KafkaConfig {


    @Bean
    public NewTopic traderTopic() {
        return TopicBuilder.name("TRADER")
                .partitions(2)
                .replicas(1)
                .build();
    }
}
