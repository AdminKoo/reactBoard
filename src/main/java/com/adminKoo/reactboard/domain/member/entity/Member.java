package com.adminKoo.reactboard.domain.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter
@NoArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 30, unique = true)
    private String userName;

    @Column(name = "password" ,nullable = false)
    private String password;

    @Column(name = "nickname", nullable = false, length = 20)
    private String nickName;

    @Enumerated(EnumType.STRING)
    private Role roles;

}
