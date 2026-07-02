package com.jjang051.security.vote.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteItemDto {
    private int itemNo;
    private int voteNo;
    private String itemText;
    private int count;
}
