package com.example.music_album.service;

import com.example.music_album.entity.Payment;
import com.example.music_album.util.JsonToObjectConverterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    @KafkaListener(topics = "payment-topic", groupId = "my-group")
    public void listenPayment(String msg) {
        Payment payment = JsonToObjectConverterUtil.convertJsonStringToObject(msg, Payment.class);
        System.out.println("payment recieved of "+payment.getAmount()+" from user " + payment.getUsername() + " for order id "+payment.getOrderId());

    }
}
