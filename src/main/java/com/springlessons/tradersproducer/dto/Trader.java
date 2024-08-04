package com.springlessons.tradersproducer.dto;

import java.io.Serializable;

public record Trader(String id, String name,
                     String descriptionData,
                     String paymentData) {
}
