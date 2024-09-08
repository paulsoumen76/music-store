package com.example.music_album.service;

import com.example.music_album.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private  StreamBridge streamBridge;
    public void createOrder(Order order) {
        log.info("order created successfully");
        streamBridge.send("orderOutput-0", MessageBuilder
                .withPayload(order)
                .setHeader("type", Order.class.getName())
                .build());
    }

}
