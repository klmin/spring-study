package com.example.study.redis.repository;

import com.example.study.redis.member.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisRepositoryTest {

    @Autowired
    private RedisRepository redisRepository;

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
    void 등록(){

        redisRepository.insert("member:"+id, member, 60, TimeUnit.SECONDS);
        Member findMember = redisRepository.get("member:"+id, Member.class);

        assertEquals(findMember.getId(), id);
        assertEquals(findMember.getName(), name);
        assertEquals(findMember.getAge(), age);
        assertEquals(findMember.getHobby(), hobby);
        assertEquals(findMember.getScore(), score);

        String testKey = "testKey1";
        String testValue = "testValue1";
        redisRepository.insert(testKey, testValue, 60, TimeUnit.SECONDS);
        String test = redisRepository.get(testKey);
        assertEquals(test, testValue);
    }

    @Test
    void 찾기(){
        redisRepository.insert("member:"+id, member, 60, TimeUnit.SECONDS);
        Member successFindMember = redisRepository.find("member:"+id, Member.class).orElse(null);
        assertEquals(successFindMember.getId(), id);
        assertEquals(successFindMember.getName(), name);
        assertEquals(successFindMember.getAge(), age);
        assertEquals(successFindMember.getHobby(), hobby);
        assertEquals(successFindMember.getScore(), score);

        Member failFindMember = redisRepository.find("member1:"+id, Member.class).orElse(null);
        assertNull(failFindMember);
    }

    @Test
    void 만료시간확인(){

        int timeout = 121;

        redisRepository.insert("member:"+id, member, timeout, TimeUnit.MINUTES);
        Long expirationSeconds = redisRepository.getKeyExpiration("member:"+id, TimeUnit.SECONDS);
        assertEquals((timeout*60)-1, expirationSeconds);

        Long expirationMinutes = redisRepository.getKeyExpiration("member:"+id, TimeUnit.MINUTES);
        assertEquals(timeout-1, expirationMinutes);

        Long expirationHours = redisRepository.getKeyExpiration("member:"+id, TimeUnit.HOURS);
        assertEquals(timeout/60, expirationHours);

    }

}