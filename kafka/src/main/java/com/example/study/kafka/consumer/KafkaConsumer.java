package com.example.study.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "test-topic", groupId = "test-group")
    public void test(Object message) {
        log.info("received message: {}", message);
    }
}
