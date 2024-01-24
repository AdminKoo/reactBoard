package com.adminKoo.reactboard.domain.member.entity;

import com.adminKoo.reactboard.domain.board.entity.Board;
import com.adminKoo.reactboard.domain.comment.entity.Comment;
import com.adminKoo.reactboard.domain.member.dto.MemberResponseDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@NoArgsConstructor
@Table(name = "tb_member")
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

    /* 회원 삭제하면 게시글같이 삭제 */
    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boardList = new ArrayList<>();
     /* 회원 삭제하면 댓글같이 삭제 */
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();

    @Builder
    public Member(String userName, String password, String nickName) {
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
    }

    public void setBoard(Board board) {
        boardList.add(board);
    }
    public void setComment(Comment comment) {
        commentList.add(comment);
    }


    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

}
