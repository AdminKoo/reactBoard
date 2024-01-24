package com.adminKoo.reactboard.domain.member.controller;

import com.adminKoo.reactboard.domain.member.dto.MemberJoinDto;
import com.adminKoo.reactboard.domain.member.dto.MemberResponseDto;
import com.adminKoo.reactboard.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/join")
    public ResponseEntity<?> memberJoin(@RequestBody MemberJoinDto memberJoinDto) {

        MemberResponseDto dto = memberService.memberJoin(memberJoinDto);

        return ResponseEntity.ok().body(dto);
    }

}
