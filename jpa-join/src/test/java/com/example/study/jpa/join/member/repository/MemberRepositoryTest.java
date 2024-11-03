package com.example.study.jpa.join.member.repository;

import com.example.study.jpa.join.member.dto.MemberTeamDTO;
import com.example.study.jpa.join.member.dto.MemberTeamDTO2;
import com.example.study.jpa.join.member.entity.Member;
import com.example.study.jpa.join.member.projection.MemberRecordProjection;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@ActiveProfiles({"test", "postgres"})
@Sql("/test/insert.sql")
@Slf4j
class MemberRepositoryTest {

    @Autowired
    public MemberRepository memberRepository;

    @Test
    void findAll(){

        List<Member> findAll = memberRepository.findAll();
        log.info("findAll.size() : {}",findAll.size());
        findAll.forEach(m -> {
            log.info("m.getMemberId() : {}",m.getMemberId());
            log.info("m.getTeam().getTeamName() : {}", m.getTeam().getTeamName());

        });


    }

    @Test
    void findAllFetch(){

        List<Member> findAllFetch = memberRepository.findAllFetch();
        log.info("findAllFetch.size() : {}",findAllFetch.size());
        findAllFetch.forEach(m -> {
            log.info("m.getMemberId() : {}",m.getMemberId());
            log.info("m.getTeam().getTeamName() : {}", m.getTeam().getTeamName());

        });

    }

    @Test
    void findAllEntityGraph(){

        List<Member> findAllEntityGraph = memberRepository.findAllEntityGraph();
        log.info("findAllEntityGraph.size() : {}",findAllEntityGraph.size());
        findAllEntityGraph.forEach(m -> {
            log.info("m.getMemberId() : {}",m.getMemberId());
            log.info("m.getTeam().getTeamName() : {}", m.getTeam().getTeamName());

        });
    }

    @Test
    void findAllDTO(){
        List<MemberTeamDTO> findAllDTO = memberRepository.findAllDTO();
        log.info("findAllDTO.size() : {}",findAllDTO.size());
        findAllDTO.forEach(m -> {
            log.info("m.getMemberId() : {}",m.getMemberId());
            log.info("m.getMemberName() : {}",m.getMemberName());
            log.info("m.getTeam().getTeamId() : {}",m.getTeam().getTeamId());
            log.info("m.getTeam().getTeamName() : {}",m.getTeam().getTeamName());
        });
    }

    @Test
    void findAllDTO2(){
        List<MemberTeamDTO2> findAllDTO2 = memberRepository.findAllDTO2();
        log.info("findAllDTO2.size() : {}",findAllDTO2.size());
        findAllDTO2.forEach(m -> {
            log.info("m.getMemberId() : {}",m.getMemberId());
            log.info("m.getMemberName() : {}",m.getMemberName());
            log.info("m.getTeam().getTeamId() : {}",m.getTeamId());
            log.info("m.getTeam().getTeamName() : {}",m.getTeamName());
        });
    }

    @Test
    void findAllRecord(){
        List<MemberRecordProjection> memberRecordProjection = memberRepository.findAllRecord();
        log.info("findAllDTO2.size() : {}",memberRecordProjection.size());
        memberRecordProjection.forEach(m -> {
            log.info("m.getMemberId() : {}",m.memberId());
            log.info("m.getMemberName() : {}",m.name());
            log.info("m.getTeam().getTeamId() : {}",m.teamTeamId());
            log.info("m.getTeam().getTeamName() : {}",m.teamTeamName());
        });
    }

}