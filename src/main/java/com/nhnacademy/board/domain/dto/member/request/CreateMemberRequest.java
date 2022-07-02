package com.nhnacademy.board.domain.dto.member.request;

import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateMemberRequest {

    @NotNull
    private String email;
    @NotNull
    private String name;
    @NotNull
    private String password;

}
