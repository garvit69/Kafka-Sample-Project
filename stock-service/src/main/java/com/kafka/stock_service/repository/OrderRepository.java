package com.kafka.stock_service.repository;

import com.kafka.base_domains.dto.Order;
import com.kafka.base_domains.dto.OrderEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEvent,String> {
}
