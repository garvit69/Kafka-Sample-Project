package com.kafka.base_domains.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
    private String message;
    private String status;
    private Order order;
    private String email;
}
