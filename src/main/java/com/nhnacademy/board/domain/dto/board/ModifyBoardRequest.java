package com.nhnacademy.board.domain.dto.board;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ModifyBoardRequest {

    @NotNull
    private String title;

    @NotNull
    private String content;
}
