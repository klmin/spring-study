package com.example.study.redis.member.service;

import com.example.study.redis.member.entity.Member;
import com.example.study.redis.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;


    @Override
    public Member findById(String id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Member insert(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member update(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void delete(String id) {
        memberRepository.deleteById(id);
    }
}
