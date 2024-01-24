package com.adminKoo.reactboard.domain.board.entity;

import com.adminKoo.reactboard.domain.comment.entity.Comment;
import com.adminKoo.reactboard.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@NoArgsConstructor
@Table(name = "tb_board")
public class Board {

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false , length = 40)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "viewcount")
    private Integer viewCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writer;

    /* 게시글 지우면 댓글도 함께 삭제 */
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();

    public void setWriter(Member writer) {
        this.writer = writer;
        writer.setBoard(this);
    }
    public void setComment(Comment content) {
        commentList.add(content);
    }

}
