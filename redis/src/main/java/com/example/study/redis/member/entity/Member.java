package com.example.study.redis.member.entity;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@RedisHash("Member")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Member implements Serializable {

    private String id;
    private String name;
    private int age;
    private List<String> hobby;
    private Map<String, Object> score;

    public static Member create(String id, String name, int age, List<String> hobby, Map<String, Object> score){
        return new Member(id, name, age, hobby, score);
    }

}
