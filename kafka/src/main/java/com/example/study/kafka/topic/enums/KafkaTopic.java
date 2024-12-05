package com.example.study.kafka.topic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum KafkaTopic {
    TEST_OBJECT_TOPIC("test-object-topic", "test-group"),
    TEST_KAFKA_REQUEST_TOPIC("test-kafka-request-topic", "test-group")
    ;

    private final String topic;
    private final String group;
}
