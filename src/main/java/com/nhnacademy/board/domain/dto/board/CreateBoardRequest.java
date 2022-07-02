package com.nhnacademy.board.domain.dto.board;

import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateBoardRequest {

    @NotNull
    private String content;
    @NotNull
    private String title;
}
