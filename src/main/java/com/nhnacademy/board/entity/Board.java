package com.nhnacademy.board.entity;

import com.nhnacademy.board.domain.dto.board.CreateBoardRequest;
import com.nhnacademy.board.domain.dto.board.ModifyBoardRequest;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "board")
@Entity
@Getter
@NoArgsConstructor
public class Board {

    @Id
    @Column(name = "post_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNum;

    @ManyToOne
    @JoinColumn(name = "writer_email")
    private Member member;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    public Board(Member member, CreateBoardRequest createBoardRequest) {
        this.member = member;
        this.content = createBoardRequest.getContent();
        this.title = createBoardRequest.getTitle();
        this.createdDate = LocalDateTime.now();
    }

    public void modifyBoard(ModifyBoardRequest modifyBoardRequest) {
        this.content = modifyBoardRequest.getContent();
        this.title = modifyBoardRequest.getTitle();
    }
}
