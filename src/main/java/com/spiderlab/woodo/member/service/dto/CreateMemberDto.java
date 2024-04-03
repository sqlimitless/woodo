package com.spiderlab.woodo.member.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMemberDto {

    private Long idx;

    private String name;

    private String mail;

    private String phone;

    private String password;
}
