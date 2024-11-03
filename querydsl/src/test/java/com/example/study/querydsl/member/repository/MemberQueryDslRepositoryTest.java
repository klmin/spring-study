package com.example.study.querydsl.member.repository;

import com.example.study.querydsl.member.entity.Member;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
@ActiveProfiles({"test", "postgres"})
@Sql("/test/insert.sql")
@Slf4j
class MemberQueryDslRepositoryTest {

    @Autowired
    public MemberQueryDslRepository memberQueryDslRepository;

    @Test
    void list(){

        List<Member> list = memberQueryDslRepository.list();
        log.info("list.size() : {}",list.size());
        list.forEach(m -> {
            log.info("m.getMemberId() : {}",m.getMemberId());
            log.info("m.getMemberName() : {}",m.getName());
            log.info("m.getTeam().getTeamName() : {}",m.getTeam().getTeamName());

        });

    }

}