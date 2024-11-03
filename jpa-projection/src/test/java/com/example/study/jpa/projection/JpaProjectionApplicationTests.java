package com.example.study.jpa.projection;

import com.example.study.jpa.projection.member.entity.Member;
import com.example.study.jpa.projection.member.projection.MemberClassProjection;
import com.example.study.jpa.projection.member.projection.MemberInterfaceProjection;
import com.example.study.jpa.projection.member.projection.MemberRecordProjection;
import com.example.study.jpa.projection.member.repository.MemberRepository;
import com.example.study.jpa.projection.team.entity.Team;
import com.example.study.jpa.projection.team.projection.TeamClassProjection;
import com.example.study.jpa.projection.team.projection.TeamInterfaceProjection;
import com.example.study.jpa.projection.team.projection.TeamRecordProjection;
import com.example.study.jpa.projection.team.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@ActiveProfiles({"test", "postgres"})
@Sql("/test/insert.sql")
@Transactional
@Slf4j
class JpaProjectionApplicationTests {

    @Autowired
    public MemberRepository memberRepository;

    @Autowired
    public TeamRepository teamRepository;


    @Test
    void MemberProjectionTest() {

        List<Member> list = memberRepository.findAll();
        list.forEach(m -> {
            log.info("m.getMemberId() : {}", m.getMemberId());
            log.info("m.getName() : {}", m.getName());
            log.info("m.getTeam().getTeamId() : {}", m.getTeam().getTeamId());
            log.info("m.getTeam().getTeamName() : {}", m.getTeam().getTeamName());
        });

        List<MemberInterfaceProjection> memberInterfaceProjection = memberRepository.findAllBy(MemberInterfaceProjection.class);

        memberInterfaceProjection.forEach(m -> {
            log.info("m.getMemberId() : {}", m.getMemberId());
            log.info("m.getName() : {}", m.getName());
            log.info("m.getTeam().getTeamId() : {}", m.getTeam().getTeamId());
            log.info("m.getTeam().getTeamName() : {}", m.getTeam().getTeamName());
        });

        List<MemberRecordProjection> memberRecordProjection = memberRepository.findAllBy(MemberRecordProjection.class);

        memberRecordProjection.forEach(m -> {
            log.info("m.memberId : {}", m.memberId());
            log.info("m.name : {}", m.name());
            log.info("m.teamTeamId : {}", m.teamTeamId());
            log.info("m.teamTeamName : {}", m.teamTeamName());
        });


        List<MemberClassProjection> memberClassProjection = memberRepository.findAllBy(MemberClassProjection.class);

        memberClassProjection.forEach(m -> {
            log.info("m.getMemberId() : {}", m.getMemberId());
            log.info("m.getName() : {}", m.getName());
            log.info("m.getTeamId() : {}", m.getTeamId());
            log.info("m.getTeamName() : {}", m.getTeamName());
        });

        MemberRecordProjection memberProjection = memberRepository.findByMemberId(memberClassProjection.getFirst().getMemberId(), MemberRecordProjection.class);
        log.info("memberProjection.memberId() : {}", memberProjection.memberId());
        log.info("memberProjection.name() : {}", memberProjection.name());
        log.info("memberProjection.teamTeamId() : {}", memberProjection.teamTeamId());
        log.info("memberProjection.teamTeamName() : {}", memberProjection.teamTeamName());

    }

    @Test
    void TeamProjectionTest(){

        List<Team> team = teamRepository.findAll();

        team.forEach(t -> {
            log.info("t.getTeamId() : {}", t.getTeamId());
            log.info("t.getTeamName() : {}", t.getTeamName());
            t.getMembers().forEach(m -> {
                log.info("m.getMemberId() : {}", m.getMemberId());
                log.info("m.getName() : {}", m.getName());
            });
        });


        List<TeamInterfaceProjection> teamInterfaceProjection = teamRepository.findAllBy(TeamInterfaceProjection.class);

        teamInterfaceProjection.forEach(r -> {
            log.info("r.getTeamId : {}", r.getTeamId());
            log.info("r.getTeamName : {}", r.getTeamName());
            r.getMembers().forEach(m -> {
                log.info("m.getMemberId : {}", m.getMemberId());
                log.info("m.getName : {}", m.getName());

            });
        });

        List<TeamRecordProjection> teamRecordProjectionList = teamRepository.findAllBy(TeamRecordProjection.class);

        teamRecordProjectionList.forEach(r -> {
            log.info("r.teamId : {}", r.teamId());
            log.info("r.teamName : {}", r.teamName());
            log.info("r.membersMemberId : {}", r.membersMemberId());
            log.info("r.membersName : {}", r.membersName());


        });

        List<TeamClassProjection> teamClassProjection = teamRepository.findAllBy(TeamClassProjection.class);
        log.info("teamClassProjection.size : {}", teamClassProjection.size());
        teamClassProjection.forEach(r -> {
            log.info("r.teamId : {}", r.getTeamId());
            log.info("r.teamName : {}", r.getTeamName());
            log.info("r.membersMemberId : {}", r.getMemberId());
            log.info("r.membersName : {}", r.getMemberName());
        });



    }

}
