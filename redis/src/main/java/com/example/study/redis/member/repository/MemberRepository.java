package com.example.study.redis.member.repository;

import com.example.study.redis.member.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
}
