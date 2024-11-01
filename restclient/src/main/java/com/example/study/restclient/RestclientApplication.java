package com.example.study.restclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class RestclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestclientApplication.class, args);
    }

}
