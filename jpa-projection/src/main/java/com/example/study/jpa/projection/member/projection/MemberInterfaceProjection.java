package com.example.study.jpa.projection.member.projection;


public interface MemberInterfaceProjection {
    Long getMemberId();
    String getName();
    TeamProjection getTeam();

    interface TeamProjection{
        Long getTeamId();
        String getTeamName();
    }

}
