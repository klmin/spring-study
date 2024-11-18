package com.example.study.redis.member.service;

import com.example.study.redis.member.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    MemberServiceImpl memberService;

    @MethodSource("insert")
    @ParameterizedTest
    public void 등록(String id, String name, int age, List<String> hobby, Map<String, Object> score){

        Member entity = Member.create(id, name, age, hobby, score);

        Member insertEntity = memberService.insert(entity);
        assertEquals(id, insertEntity.getId());
        assertEquals(name, insertEntity.getName());
        assertEquals(age, insertEntity.getAge());
        assertEquals(score, insertEntity.getScore());
        assertEquals(hobby, insertEntity.getHobby());

    }

    @MethodSource("insertAndGet")
    @ParameterizedTest
    public void 조회(String id, String name, int age, List<String> hobby, Map<String, Object> score){

        Member entity = Member.create(id, name, age, hobby, score);

        Member insertEntity = memberService.insert(entity);

        Member member = memberService.findById(insertEntity.getId());

        assertEquals(id, member.getId());
        assertEquals(name, member.getName());
        assertEquals(age, member.getAge());
        assertEquals(score, member.getScore());
        assertEquals(hobby, member.getHobby());

    }

    public static Stream<Arguments> insert(){
        return Stream.of(
                Arguments.of(UUID.randomUUID().toString(), "테스트3", 20, List.of("여행", "사진"), Map.of("수학", 100, "영어", 95))
        );
    }
    public static Stream<Arguments> insertAndGet(){
        return Stream.of(
                Arguments.of(UUID.randomUUID().toString(), "테스트1", 20, List.of("음악", "영화감상"), Map.of("수학", 80, "영어", 90))
        );
    }

}