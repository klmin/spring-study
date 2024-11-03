package com.example.study.querydsl.member.repository;


import com.example.study.querydsl.member.entity.Member;
import com.example.study.querydsl.member.entity.QMember;
import com.example.study.querydsl.team.entity.QTeam;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberQueryDslRepository {
    private final JPAQueryFactory queryFactory;

    public List<Member> list(){
        QMember member = QMember.member;
        QTeam team = QTeam.team;
        return queryFactory
                .selectFrom(member)
                .innerJoin(member.team, team)
                .fetchJoin()
                .fetch();
    }
}
