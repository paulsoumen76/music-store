//package com.example.music_album;
//
//import com.example.music_album.entity.Orders;
//import com.example.music_album.repository.OrderRepository;
//import com.example.music_album.service.OrderService;
//import com.example.music_album.springcloudstream.OrderConsumer;
//import com.example.music_album.util.JsonToObjectConverterUtil;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.test.EmbeddedKafkaBroker;
//import org.springframework.kafka.test.context.EmbeddedKafka;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest(classes = MusicAlbumApplication.class)
//@EmbeddedKafka(brokerProperties = {"listeners=PLAINTEXT://localhost:9096"}, partitions = 1)
//public class ConsumerTest {
//    @Autowired
//    private OrderRepository orderRepository;
//    @Autowired
//    private OrderService orderService;
//    @Autowired
//    private KafkaTemplate<String, Orders> kafkaTemplate;
//    @Autowired
//    private EmbeddedKafkaBroker embeddedKafkaBroker;
//    @Test
//    void test_consumer_order() throws InterruptedException {
//        Orders order = new Orders("100","Glory","john_doe",2500.0d);
//        kafkaTemplate.send("order-topic",order);
//        Thread.sleep(40000);
//        assertEquals(orderRepository.findById("100").get().getAlbumTitle(),"Glory");
//        assertEquals(orderRepository.findById("100").get().getUsername(),"john_doe");
//    }
//}
