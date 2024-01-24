package com.adminKoo.reactboard.domain.member.service;

import com.adminKoo.reactboard.domain.member.dto.MemberJoinDto;
import com.adminKoo.reactboard.domain.member.dto.MemberResponseDto;
import com.adminKoo.reactboard.domain.member.entity.Member;
import com.adminKoo.reactboard.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberResponseDto memberJoin(MemberJoinDto memberJoinDto) {

        /* 아이디 검사 */
        if(memberRepository.findByuserName(memberJoinDto.getUserName()).isPresent()) {
            throw new RuntimeException("이미 존재하는 아이디");
        }
        /* 비밀번호 확인 */
        checkPassword(memberJoinDto.getPassword(), memberJoinDto.getPassword2());

        Member saveMember = memberJoinDto.toEntity();
        /* 암호화 */
        saveMember.encodePassword(passwordEncoder);

        memberRepository.save(saveMember);

        return new MemberResponseDto(saveMember);
    }

    private void checkPassword(String password, String password2) {
        if(!password.equals(password2)) {
            throw new RuntimeException("패스워드 불일치");
        }
    }
}
