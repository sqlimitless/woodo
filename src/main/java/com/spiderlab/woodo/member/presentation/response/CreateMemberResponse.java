package com.spiderlab.woodo.member.presentation.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMemberResponse {

    private long idx;

    private String name;

    private String mail;

    private String phone;
}
