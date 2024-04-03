package com.spiderlab.woodo.member.presentation;

import com.spiderlab.woodo.member.presentation.request.CreateMemberRequest;
import com.spiderlab.woodo.member.presentation.response.CreateMemberResponse;
import com.spiderlab.woodo.member.service.CreateMemberService;
import com.spiderlab.woodo.member.service.dto.CreateMemberDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final CreateMemberService createMemberService;
    private final ModelMapper modelMapper;

    @PostMapping("/member")
    public ResponseEntity<?> createMember(@Validated @RequestBody CreateMemberRequest createMemberRequest) {
        CreateMemberDto createMemberDto = modelMapper.map(createMemberRequest, CreateMemberDto.class);
        // 중복체크
        if(createMemberService.existsByMail(createMemberRequest.getMail())) {
            return ResponseEntity
                    .badRequest()
                    .body("이미 가입된 메일 주소입니다.");
        }
        // 저장
        CreateMemberDto memberDto = createMemberService.createMember(createMemberDto);
        CreateMemberResponse createMemberResponse = modelMapper.map(memberDto, CreateMemberResponse.class);
        return ResponseEntity.ok(createMemberResponse);
    }
}
