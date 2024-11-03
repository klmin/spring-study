package com.example.study.jpa.join.team.dto;



import com.example.study.jpa.join.member.entity.Member;

import java.util.List;

public class TeamMembersDTO {

    private Long teamId;
    private String teamName;
    private List<Member> members; // 연관된 Member 객체 리스트 포함

    public TeamMembersDTO(Long teamId, String teamName, List<Member> members) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.members = members;
    }
}
