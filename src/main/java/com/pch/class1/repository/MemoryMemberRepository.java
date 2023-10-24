package com.pch.class1.repository;

import com.pch.class1.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // 실무에서는 공유되는 변수일 때 concurrentHashMap 사용해야함.
    private static long sequence = 0L; // 실무에선 동시성 문제로 AtomicLong 사용

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null return할 가능성때문에 Optional로 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // java8 이후 for문처럼 사용되는 람다식
                .filter(member -> member.getName().equals(name)) // member 내부에서 name과 같은 애를 찾는다
                .findAny(); //하나라도 찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
