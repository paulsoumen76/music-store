package com.example.music_album.springcloudstream;

import com.example.music_album.entity.Order;
import com.example.music_album.entity.Payment;
import com.example.music_album.service.OrderService;
import com.example.music_album.util.JsonToObjectConverterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    @Autowired
    private StreamBridge streamBridge;
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    @KafkaListener(topics = "order-topic", groupId = "my-group")
    public void listenOrder(String msg) {
        Order order = JsonToObjectConverterUtil.convertJsonStringToObject(msg, Order.class);
        System.out.println("order received with id::"+order.getId()+ " of " + order.getUsername() +" for product " + order.getAlbumTitle());
        createPayment(order);
    }
    public void createPayment(Order order){
        log.info("creating payment");
        Payment payment = new Payment("100", order.getId(), order.getAmount(), order.getUsername(), order.getAlbumTitle());
        streamBridge.send("paymentOutput-0", payment);
    }
}
