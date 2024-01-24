package com.adminKoo.reactboard.domain.comment.entity;

import com.adminKoo.reactboard.domain.board.entity.Board;
import com.adminKoo.reactboard.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tb_comment")
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false, name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    public void setMember(Member member) {
        this.member = member;
        member.setComment(this);
    }
    public void setBoard(Board board) {
        this.board = board;
        board.setComment(this);
    }

}
