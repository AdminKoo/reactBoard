package com.adminKoo.reactboard.domain.member.repository;

import com.adminKoo.reactboard.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByuserName(String userName);
}
