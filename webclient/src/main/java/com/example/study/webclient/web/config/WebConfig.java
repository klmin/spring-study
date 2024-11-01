package com.example.study.webclient.web.config;


import com.example.study.webclient.objectmapper.formatter.LocalDateFormatter;
import com.example.study.webclient.objectmapper.formatter.LocalDateTimeFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new LocalDateFormatter());
        registry.addFormatter(new LocalDateTimeFormatter());
    }
}