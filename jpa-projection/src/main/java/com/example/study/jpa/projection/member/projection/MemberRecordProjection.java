package com.example.study.jpa.projection.member.projection;

public record MemberRecordProjection(
        Long memberId,
        String name,
        Long teamTeamId,
        String teamTeamName
) {

}

