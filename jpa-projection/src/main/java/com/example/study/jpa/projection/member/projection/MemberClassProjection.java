package com.example.study.jpa.projection.member.projection;


import lombok.Getter;

@Getter
public class MemberClassProjection

{
    private Long memberId;
    private String name;
    private Long teamId;
    private String teamName;

    public MemberClassProjection(Long memberId, String name, Long teamTeamId, String teamTeamName){
        this.memberId = memberId;
        this.name = name;
        this.teamId = teamTeamId;
        this.teamName = teamTeamName;
    }

}


