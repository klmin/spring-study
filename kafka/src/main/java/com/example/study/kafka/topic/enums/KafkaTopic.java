package com.example.study.kafka.topic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum KafkaTopic {
    TEST_STRING_TOPIC("test-string-topic", "test-group"),
    TEST_OBJECT_TOPIC("test-object-topic", "test-group")
    ;

    private final String topic;
    private final String group;
}
