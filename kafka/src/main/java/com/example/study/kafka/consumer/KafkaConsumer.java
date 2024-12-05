package com.example.study.kafka.consumer;

import com.example.study.kafka.request.KafkaRequest;
import com.example.study.kafka.topic.enums.KafkaTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(
            topics = "#{T(com.example.study.kafka.topic.enums.KafkaTopic).TEST_OBJECT_TOPIC.getTopic()}",
            groupId = "#{T(com.example.study.kafka.topic.enums.KafkaTopic).TEST_OBJECT_TOPIC.getGroup()}"
    )
    public void handleTestObjectTopicMessage(Object message) {
        log(KafkaTopic.TEST_OBJECT_TOPIC.getTopic(), message);
    }

    @KafkaListener(
            topics = "#{T(com.example.study.kafka.topic.enums.KafkaTopic).TEST_KAFKA_REQUEST_TOPIC.getTopic()}",
            groupId = "#{T(com.example.study.kafka.topic.enums.KafkaTopic).TEST_KAFKA_REQUEST_TOPIC.getGroup()}"
    )
    public void handleTestKafkaRequestTopicMessage(KafkaRequest message) {
        log(KafkaTopic.TEST_KAFKA_REQUEST_TOPIC.getTopic(), message);
    }

    private void log(String topic, Object message) {
        log.info("[{}] received message: {}", KafkaTopic.TEST_KAFKA_REQUEST_TOPIC.getTopic() ,message);
    }
}
