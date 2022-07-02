package com.nhnacademy.board.entity;

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
    @JoinColumn(name = "writer_emailr")
    private Member member;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;
}
