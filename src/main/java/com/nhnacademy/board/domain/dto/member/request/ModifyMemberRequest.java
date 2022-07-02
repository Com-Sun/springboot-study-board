package com.nhnacademy.board.domain.dto.member.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ModifyMemberRequest {

    @NotNull
    private String password;
}
