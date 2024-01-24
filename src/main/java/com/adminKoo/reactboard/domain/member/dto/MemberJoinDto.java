package com.adminKoo.reactboard.domain.member.dto;

import com.adminKoo.reactboard.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberJoinDto {

    private String userName;

    private String password;
    private String password2;

    private String nickName;

    public MemberJoinDto(String userName, String password, String password2, String nickName) {
        this.userName = userName;
        this.password = password;
        this.password2 = password2;
        this.nickName = nickName;
    }

    public Member toEntity() {
        return Member.builder().
                userName(userName)
                .password(password)
                .nickName(nickName)
                .build();
    }
}
