package com.nhnacademy.board.domain.dto.reply.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateReplyRequest {

    @NotNull
    private String replier;
    @NotNull
    private String content;
}
