package com.kafka.email_service.kafka;

import com.kafka.base_domains.dto.Order;
import com.kafka.base_domains.dto.OrderEvent;
import com.kafka.email_service.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class OrderConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    private EmailService emailService;

        @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event){
        LOGGER.info(String.format("Order Event Received In EmailService-> %s", event.toString()));
        String email= event.getEmail();
        Order order=event.getOrder();
        String body="Your Order Containing: "+order.getOrderName()+" Order ID: "+order.getOrderId()+" Quantity: "+order.getQuantity()+" Invoice Value: "+order.getPrice()+"\nRegards,\nTeam Ecommerce";
            emailService.sendOrderEmail(email, "Order Confirmation", body);

    }
}
