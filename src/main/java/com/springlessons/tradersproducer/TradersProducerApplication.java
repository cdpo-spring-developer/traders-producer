package com.springlessons.tradersproducer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class TradersProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradersProducerApplication.class, args);
    }

}
