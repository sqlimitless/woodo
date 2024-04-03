package com.spiderlab.woodo.member.presentation.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMemberRequest {

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;
    @NotBlank(message = "메일은 필수 입력 값입니다.")
    @Pattern(regexp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", message = "메일 형식이 유효하지 않습니다.")
    private String mail;
    @NotBlank(message = "전화번호는 필수 입력 값입니다.")
    @Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$", message = "전화번호 형식이 유효하지 않습니다.")
    private String phone;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "^(?:(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])|(?=.*[a-z])(?=.*[0-9])|(?=.*[A-Z])(?=.*[0-9])|(?=.*[a-z])(?=.*[A-Z])).{6,10}$",
            message = "비밀번호는 6~10자 영문 대 소문자, 숫자 중 최소 두 가지 이상 조합을 사용하세요.")
    private String password;

}
