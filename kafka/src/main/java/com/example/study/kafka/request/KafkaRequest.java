package com.example.study.kafka.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class KafkaRequest {

    private String topic;
    private String name;
    private Integer grade;
    private Long number;
    private List<String> hobby;
    private Map<String, Object> score;

}
