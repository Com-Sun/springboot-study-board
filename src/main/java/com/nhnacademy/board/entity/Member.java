package com.nhnacademy.board.entity;

import com.nhnacademy.board.domain.dto.member.request.CreateMemberRequest;
import com.nhnacademy.board.domain.dto.member.request.ModifyMemberRequest;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "member")
@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    public Member (CreateMemberRequest createMemberRequest) {
        this.email = createMemberRequest.getEmail();
        this.name = createMemberRequest.getName();
        this.password = createMemberRequest.getPassword();
        this.createdDate = LocalDateTime.now();
    }

    public void modifyMember(ModifyMemberRequest modifyMemberRequest) {
        this.modifiedDate = LocalDateTime.now();
        this.password = modifyMemberRequest.getPassword();
    }
}
