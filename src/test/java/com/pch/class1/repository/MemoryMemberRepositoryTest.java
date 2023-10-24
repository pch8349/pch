package com.pch.class1.repository;

import com.pch.class1.domain.Member;
//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("한효주");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); // optional로 반환되기에 .get()을 마지막에 붙여줌
//        Assertions.assertEquals(member, null); // Jupyter 제공 Assertion 사용, member가 result와 같은지(member 자리에 비교값, result 자리에 기대값 넣기)
//        Assertions.assertThat(member).isEqualTo(result); // core.api 제공하는게 더 읽기 편하다! Assertions에서 alt+ enter 하면 static으로 박아줌
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findById() {
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("찬혁");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("서린");
        repository.save(member2);

        Member result = repository.findByName("찬혁").get();


    }

    @Test
    void findAll() {
    }
}