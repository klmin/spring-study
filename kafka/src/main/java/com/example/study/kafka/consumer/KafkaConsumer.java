package com.example.study.kafka.consumer;

import com.example.study.kafka.request.KafkaRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(
            topics = "#{T(com.example.study.kafka.topic.enums.KafkaTopic).TEST_STRING_TOPIC.getTopic()}",
            groupId = "#{T(com.example.study.kafka.topic.enums.KafkaTopic).TEST_STRING_TOPIC.getGroup()}"
    )
    public void handleTestTopicMessage(Object message) {
        log.info("[test-string-topic] received message: {}", message);
    }

    @KafkaListener(
            topics = "#{T(com.example.study.kafka.topic.enums.KafkaTopic).TEST_OBJECT_TOPIC.getTopic()}",
            groupId = "#{T(com.example.study.kafka.topic.enums.KafkaTopic).TEST_OBJECT_TOPIC.getGroup()}"
    )
    public void handleTestScoreTopicMessage(KafkaRequest message) {
        log.info("[test-object-topic] received message: {}", message);
    }
}
