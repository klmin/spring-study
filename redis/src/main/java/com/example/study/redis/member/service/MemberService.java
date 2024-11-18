package com.example.study.redis.member.service;

import com.example.study.redis.member.entity.Member;

public interface MemberService {

    Member findById(String id);
    Member insert(Member member);
    Member update(Member member);
    void delete(String id);
}
