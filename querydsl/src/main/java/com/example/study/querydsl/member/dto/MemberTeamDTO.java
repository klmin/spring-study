package com.example.study.querydsl.member.dto;


import com.example.study.querydsl.team.entity.Team;
import lombok.Getter;

@Getter
public class MemberTeamDTO {
    private Long memberId;
    private String memberName;
    private Team team; // Team 객체를 포함한 DTO

    public MemberTeamDTO(Long memberId, String memberName, Team team) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.team = team;
    }
}
