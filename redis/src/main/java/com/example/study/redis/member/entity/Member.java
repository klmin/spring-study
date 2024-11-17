package com.example.study.redis.member.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RedisHash("User")
@Getter
@Setter
public class Member implements Serializable {

    @Id
    private Long id;
    private String name;
    private int age;
    private List<String> hobby = new ArrayList<>();
    private Map<String, Object> score = new HashMap<>();

}
