package com.adminKoo.reactboard.domain.member.dto;

import com.adminKoo.reactboard.domain.member.entity.Member;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class MemberResponseDto {

    private String userName;
    private String nickName;

    public MemberResponseDto(Member member) {
        this.userName = member.getUserName();
        this.nickName = member.getNickName();
    }
}
