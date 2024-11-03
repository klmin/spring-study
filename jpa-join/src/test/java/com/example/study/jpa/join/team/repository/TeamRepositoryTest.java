package com.example.study.jpa.join.team.repository;

import com.example.study.jpa.join.team.entity.Team;
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
class TeamRepositoryTest {

    @Autowired
    public TeamRepository teamRepository;

    @Test
    void findAll(){
        List<Team> findAll = teamRepository.findAll();
        log.info("findAll.size() : {}",findAll.size());
        findAll.forEach(t -> {
            log.info("t.getTeamName() : {}", t.getTeamName());
            t.getMembers().forEach(m -> {
                log.info("m.getMemberId() : {}",m.getMemberId());
            });
        });

    }

    @Test
    void findAllFetch(){
        List<Team> findAllFetch = teamRepository.findAllFetch();
        log.info("findAllFetch.size() : {}",findAllFetch.size());
        findAllFetch.forEach(t -> {
            log.info("t.getTeamName() : {}", t.getTeamName());
            t.getMembers().forEach(m -> {
                log.info("m.getMemberId() : {}",m.getMemberId());
            });
        });
    }

    @Test
    void findAllEntityGraph(){
        List<Team> findAllEntityGraph = teamRepository.findAllEntityGraph();
        log.info("findAllEntityGraph.size() : {}",findAllEntityGraph.size());
        findAllEntityGraph.forEach(t -> {
            log.info("t.getTeamName() : {}", t.getTeamName());
            t.getMembers().forEach(m -> {
                log.info("m.getMemberId() : {}",m.getMemberId());
            });
        });
    }

}