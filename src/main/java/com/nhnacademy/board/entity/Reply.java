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

@Getter
@Entity
@Table(name = "board")
@NoArgsConstructor
public class Reply {

    @Id
    @Column(name = "reply_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyNum;

    @ManyToOne
    @JoinColumn(name = "post_num")
    private Board board;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column
    private String replier;

    @Column
    private String content;
}
