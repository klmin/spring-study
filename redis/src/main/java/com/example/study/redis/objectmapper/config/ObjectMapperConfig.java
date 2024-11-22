package com.example.study.redis.objectmapper.config;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper(){

        JavaTimeModule module = new JavaTimeModule();
        return new ObjectMapper().registerModule(module)
                                 .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

}
