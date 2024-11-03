package com.example.study.jpa.join.team.projection;

public record TeamRecordProjection(
    Long teamId,
    String teamName,
    Long membersMemberId,
    String membersName

) {
}
