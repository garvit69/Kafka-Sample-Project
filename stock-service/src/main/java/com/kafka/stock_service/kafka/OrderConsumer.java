package com.kafka.stock_service.kafka;

import com.kafka.base_domains.dto.OrderEvent;
import com.kafka.stock_service.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    private OrderRepository orderRepository;

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event){
LOGGER.info(String.format("Order Event Received In StockService-> %s", event.toString()));
     orderRepository.save(event);
        LOGGER.info("Order Saved to DB");

    }
}
