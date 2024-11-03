package com.example.study.jpa.projection.team.projection;

public record TeamRecordProjection(
    Long teamId,
    String teamName,
    Long membersMemberId,
    String membersName

) {
}
