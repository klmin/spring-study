package com.example.study.jpa.join.team.projection;

import lombok.Getter;

@Getter
public class TeamClassProjection{
    private Long teamId;
    private String teamName;
    private Long memberId;
    private String memberName;

    public TeamClassProjection(Long teamId, String teamName, Long membersMemberId, String membersName) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.memberId = membersMemberId;
        this.memberName = membersName;
    }



}
