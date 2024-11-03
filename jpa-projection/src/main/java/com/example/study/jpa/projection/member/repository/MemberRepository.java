package com.example.study.jpa.projection.member.repository;


import com.example.study.jpa.projection.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    <T> List<T> findAllBy(Class<T> clazz);
    <T> T findByMemberId(Long id, Class<T> projection);
}
