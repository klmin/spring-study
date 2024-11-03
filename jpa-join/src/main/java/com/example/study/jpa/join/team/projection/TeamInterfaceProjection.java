package com.example.study.jpa.join.team.projection;

import java.util.List;

public interface TeamInterfaceProjection {
    Long getTeamId();
    String getTeamName();
    List<MemberProjection> getMembers();

    interface MemberProjection{
        Long getMemberId();
        String getName();

    }
}
