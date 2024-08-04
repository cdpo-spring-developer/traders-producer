package com.springlessons.tradersproducer.service.kafka;

import com.springlessons.tradersproducer.dto.Trader;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@EnableScheduling
public class TraderGenerator {
    private final TraderProducer traderProducer;

    public TraderGenerator(TraderProducer traderProducer) {
        this.traderProducer = traderProducer;
    }

    @Scheduled(fixedRate = 5000)
    public void produceTrader() {
        String[] names = {"Trader #1", "Trader #2", "Trader #3", "Trader #4"};
        String[] descs = {"Desc #1", "Desc #2", "Desc #3", "Desc #4"};
        String[] payments = {"Pay #1", "Pay #2", "Pay #3", "Pay #4"};
        Trader trader = new Trader(UUID.randomUUID().toString(),
                names[(int) (Math.random() * names.length)],
                descs[(int) (Math.random() * descs.length)],
                payments[(int) (Math.random() * payments.length)]
        );
        String[] keys = {"key #1", "key #2"};
        String key = keys[(int) (Math.random() * keys.length)];
        traderProducer.sendMessage("TRADER", key, trader)
                .whenComplete((stringTraderSendResult, throwable) -> {
                    if (throwable != null) {
                        System.out.println(throwable.getMessage());
                    } else {
                        System.out.println("Trader sent successfully: " + trader);
                        System.out.println("KEY: " + key);
                        System.out.println("Partition: " + stringTraderSendResult.getRecordMetadata().partition());
                    }
                });
    }
}
