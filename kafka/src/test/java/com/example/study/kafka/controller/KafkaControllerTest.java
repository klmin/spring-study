package com.example.study.kafka.controller;

import com.example.study.kafka.request.KafkaRequest;
import com.example.study.kafka.topic.enums.KafkaTopic;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class KafkaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("카프카 요청 테스트 GET")
    @ParameterizedTest
    @MethodSource("fetchGet")
    void get요청(String topic, String name, Integer grade, Long number, List<String> hobby, Map<String, Object> score) throws Exception {

        KafkaRequest kafkaRequest = initKafkaRequest(topic, name, grade, number, hobby, score);

        Map<String, Object> editMap = objectMapper.convertValue(kafkaRequest, new TypeReference<>() {});

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();

        editMap.forEach((key, value) -> {
            if (value instanceof List) {
                ((List<?>) value).forEach(item -> multiValueMap.add(key, item.toString()));
            } else if (value instanceof Map) {
                ((Map<?, ?>) value).forEach((mapKey, mapValue) ->
                        multiValueMap.add(key + "[" + mapKey + "]", mapValue.toString())
                );
            } else {
                multiValueMap.add(key, value != null ? value.toString() : null);
            }
        });

        mockMvc.perform(get("/kafka/send")
                .params(multiValueMap)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));

        Thread.sleep(10000);
    }

    private static Stream<Arguments> fetchGet() {
        return Stream.of(
                Arguments.of(KafkaTopic.TEST_OBJECT_TOPIC.getTopic(), "테스트이름", 1, 90L, List.of("수영", "음악"), Map.of("수학",90,"영어",80)),
                Arguments.of(KafkaTopic.TEST_KAFKA_REQUEST_TOPIC.getTopic(), "테스트이1", 2, 91L, List.of("영어", "운동"), Map.of("수학",70,"영어",70))
        );
    }

    @DisplayName("카프카 요청 테스트 POST")
    @ParameterizedTest
    @MethodSource("fetchPost")
    void post요청(String topic, String name, Integer grade, Long number, List<String> hobby, Map<String, Object> score) throws Exception {

        KafkaRequest kafkaRequest = initKafkaRequest(topic, name, grade, number, hobby, score);

        mockMvc.perform(post("/kafka/send")
                        .content(objectMapper.writeValueAsString(kafkaRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));

        Thread.sleep(10000);

    }

    private static Stream<Arguments> fetchPost() {
        return Stream.of(
                Arguments.of(KafkaTopic.TEST_OBJECT_TOPIC.getTopic(), "테스트이름2", 3, 93L, List.of("게임", "공부"), Map.of("수학",95,"영어",85)),
                Arguments.of(KafkaTopic.TEST_KAFKA_REQUEST_TOPIC.getTopic(), "테스트이름3", 4, 94L, List.of("축구", "야구"), Map.of("수학",60,"영어",60))
        );
    }

    private KafkaRequest initKafkaRequest(String topic, String name, Integer grade, Long number, List<String> hobby, Map<String, Object> score){
        KafkaRequest kafkaRequest = new KafkaRequest();

        Map<String, Object> fieldValues = Map.of(
                "topic", topic,
                "name", name,
                "grade", grade,
                "number", number,
                "hobby", hobby,
                "score", score
        );

        fieldValues.forEach((field, value) -> {
            ReflectionTestUtils.setField(kafkaRequest, field, value);
        });

        return kafkaRequest;
    }

}