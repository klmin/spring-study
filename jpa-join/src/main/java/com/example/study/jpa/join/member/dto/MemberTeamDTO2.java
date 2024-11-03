package com.example.study.jpa.join.member.dto;

import lombok.Getter;

@Getter
public class MemberTeamDTO2 {
    private Long memberId;
    private String memberName;
    private Long teamId;
    private String teamName;

    public MemberTeamDTO2(Long memberId, String memberName, Long teamId, String teamName) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.teamId = teamId;
        this.teamName = teamName;
    }
}
