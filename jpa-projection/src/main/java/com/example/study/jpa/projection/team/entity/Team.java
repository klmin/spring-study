package com.example.study.jpa.projection.team.entity;


import com.example.study.jpa.projection.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@SequenceGenerator(name="TEAM_SEQ_GENERATOR", sequenceName="TEAM_SEQ", initialValue = 1, allocationSize = 1)
public class Team {

    @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator="TEAM_SEQ_GENERATOR")
    private Long teamId;

    @Column
    private String teamName;

    @Column
    private Integer teamNum;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Member> members = new ArrayList<>();

}
