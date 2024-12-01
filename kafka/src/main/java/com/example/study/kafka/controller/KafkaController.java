package com.example.study.kafka.controller;

import com.example.study.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public ResponseEntity<String> sendMessageWithGet(@RequestParam String message) {
        kafkaProducer.sendMessage("test-topic", message);
        String response = "GET Message Sent : "+message;
        return ResponseEntity.ok(response);
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessageWithPost(@RequestBody String message) {
        kafkaProducer.sendMessage("test-topic", message);
        String response = "POST Message Sent : "+message;
        return ResponseEntity.ok(response);
    }
}
