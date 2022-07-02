package com.nhnacademy.board.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.board.entity.Member;
import java.time.LocalDateTime;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.util.ReflectionTestUtils;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("엔티티 맵핑이 제대로 되었는가 테스트")
    @Test
    public void testInsertMembers() {

        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = new Member();

            ReflectionTestUtils.setField(member, "email", "email" + i);
            ReflectionTestUtils.setField(member, "name", "name");
            ReflectionTestUtils.setField(member, "password", "password213");
            ReflectionTestUtils.setField(member, "createdDate", LocalDateTime.now());

            memberRepository.save(member);
        });

        assertThat(memberRepository.findAll()).hasSize(100);
    }
}