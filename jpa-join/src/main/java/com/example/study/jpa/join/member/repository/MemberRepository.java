package com.example.study.jpa.join.member.repository;


import com.example.study.jpa.join.member.dto.MemberTeamDTO;
import com.example.study.jpa.join.member.dto.MemberTeamDTO2;
import com.example.study.jpa.join.member.entity.Member;
import com.example.study.jpa.join.member.projection.MemberRecordProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    <T> List<T> findAllBy(Class<T> clazz);
    <T> T findByMemberId(Long id, Class<T> projection);

    //fetch join
    @Query("SELECT m FROM Member m JOIN FETCH m.team")
    List<Member> findAllFetch();

    //entityGraph
    @EntityGraph(attributePaths = {"team"})
    @Query("SELECT m FROM Member m")
    List<Member> findAllEntityGraph();

    @Query("SELECT new com.example.study.jpa.join.member.dto.MemberTeamDTO(m.memberId, m.name, t) FROM Member m JOIN m.team t")
    List<MemberTeamDTO> findAllDTO();

    @Query("SELECT new com.example.study.jpa.join.member.dto.MemberTeamDTO2(m.memberId, m.name, t.teamId, t.teamName) FROM Member m JOIN m.team t")
    List<MemberTeamDTO2> findAllDTO2();

    @Query("SELECT new com.example.study.jpa.join.member.projection.MemberRecordProjection(m.memberId, m.name, t.teamId, t.teamName) FROM Member m JOIN m.team t")
    List<MemberRecordProjection> findAllRecord();


}
