package com.nhnacademy.board.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.board.entity.Board;
import com.nhnacademy.board.entity.Member;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.util.ReflectionTestUtils;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("멤버 아이디로 게시글 조회 테스트")
    @Test
    void insertBoard() {

        Member member = new Member();

        ReflectionTestUtils.setField(member, "email", "email");
        ReflectionTestUtils.setField(member, "name", "name");
        ReflectionTestUtils.setField(member, "password", "password213");
        ReflectionTestUtils.setField(member, "createdDate", LocalDateTime.now());

        memberRepository.save(member);

        List<Board> boards = new ArrayList<>();

        IntStream.rangeClosed(1, 100)
            .forEach(i -> {
                Board board = new Board();
                ReflectionTestUtils.setField(board, "content", "content123");
                ReflectionTestUtils.setField(board, "title", "title23");
                ReflectionTestUtils.setField(board, "createdDate", LocalDateTime.now());
                ReflectionTestUtils.setField(board, "member", member);

                boards.add(board);
            });

        boardRepository.saveAllAndFlush(boards);
        List<Board> boardList = boardRepository.findByMember_Email(member.getEmail());

        boardList
            .forEach(board -> assertThat(board.getMember().getEmail()).isEqualTo(member.getEmail()));
    }
}