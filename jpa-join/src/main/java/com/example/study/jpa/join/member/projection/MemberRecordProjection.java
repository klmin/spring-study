package com.example.study.jpa.join.member.projection;

public record MemberRecordProjection(
        Long memberId,
        String name,
        Long teamTeamId,
        String teamTeamName
) {

}

