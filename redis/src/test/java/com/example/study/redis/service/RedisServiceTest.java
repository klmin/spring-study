package com.example.study.redis.service;

import com.example.study.redis.member.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    private Member member;
    private String id;
    private String name;
    private int age;
    private List<String> hobby;
    private Map<String, Object> score;

    @BeforeEach
    void setUp() {

        id = UUID.randomUUID().toString();
        name = "테스트";
        age = 20;
        hobby = List.of("운동", "음악");
        score = Map.of("수학", 90, "영어", 80);

        member = Member.create(id, name, age, hobby, score);
    }

    @Test
    void 조회_후_등록_유효기간_초(){

        long timeout = 200;

        Member insertMember = redisService.getOrInsertWithTTLSeconds("member:"+id,
                                                                 Member.class,
                                                                 () -> member,
                                                                 timeout);


        assertEquals(insertMember.getId(), id);
        assertEquals(insertMember.getName(), name);
        assertEquals(insertMember.getAge(), age);
        assertEquals(insertMember.getHobby(), hobby);
        assertEquals(insertMember.getScore(), score);

        Member findMember = redisService.get("member:"+id, Member.class);
        assertEquals(findMember.getId(), id);
        assertEquals(findMember.getName(), name);
        assertEquals(findMember.getAge(), age);
        assertEquals(findMember.getHobby(), hobby);
        assertEquals(findMember.getScore(), score);

        long expirationSecondsMember = redisService.getKeyExpiration("member:"+id, TimeUnit.SECONDS);
        assertEquals(timeout - 1, expirationSecondsMember);

    }

    @Test
    void 조회_후_등록_유효기간_분(){

        long timeout = 30;

        Member insertMember = redisService.getOrInsertWithTTLMinutes("member:"+id,
                Member.class,
                () -> member,
                timeout);

        String newName = "신규테스트";
        int newAge = 30;
        List<String> newHobby = List.of("컴퓨터", "영화감상");
        Map<String, Object> newScore = Map.of("국어", 70, "체육", 80);

        Member newMember = Member.create(insertMember.getId(), newName, newAge, newHobby, newScore);

        Member newInsertAndFindMember = redisService.getOrInsertWithTTLMinutes("member:"+id,
                                                                            Member.class,
                                                                            () -> newMember,
                                                                            timeout);


        assertEquals(newInsertAndFindMember.getId(), id);
        assertEquals(newInsertAndFindMember.getName(), name);
        assertEquals(newInsertAndFindMember.getAge(), age);
        assertEquals(newInsertAndFindMember.getHobby(), hobby);
        assertEquals(newInsertAndFindMember.getScore(), score);

        assertNotEquals(newInsertAndFindMember.getName(), newName);
        assertNotEquals(newInsertAndFindMember.getAge(), newAge);
        assertNotEquals(newInsertAndFindMember.getHobby(), newHobby);
        assertNotEquals(newInsertAndFindMember.getScore(), newScore);

        long expirationSecondsMember = redisService.getKeyExpiration("member:"+id, TimeUnit.MINUTES);
        assertEquals(timeout - 1, expirationSecondsMember);

    }

    @Test
    void 조회_후_등록_유효기간_시간(){

        long timeout = 2;

        Member insertMember = redisService.getOrInsertWithTTLHours("member:"+id,
                Member.class,
                () -> member,
                timeout);

        assertEquals(insertMember.getId(), id);
        assertEquals(insertMember.getName(), name);
        assertEquals(insertMember.getAge(), age);
        assertEquals(insertMember.getHobby(), hobby);
        assertEquals(insertMember.getScore(), score);

        long expirationSecondsMember = redisService.getKeyExpiration("member:"+id, TimeUnit.HOURS);
        assertEquals(timeout - 1, expirationSecondsMember);

    }

}