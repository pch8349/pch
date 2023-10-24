package com.pch.class1.repository;

import com.pch.class1.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    // optional 은 null 값을 경우 null을 그대로 반환하기보다 한번 감싸서 보내주기 위해 주로 사용한다.
    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
