package com.spiderlab.woodo.member.service;

import com.spiderlab.woodo.member.domain.MemberEntity;
import com.spiderlab.woodo.member.infra.MemberRepository;
import com.spiderlab.woodo.member.service.dto.CreateMemberDto;
import com.spiderlab.woodo.util.AES256;
import com.spiderlab.woodo.util.SHA256;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateMemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final SHA256 sha256;
    private final AES256 aes256;

    @Transactional
    public CreateMemberDto createMember(CreateMemberDto createMemberDto) {
        // 비밀번호, 전화번호 암호화
        createMemberDto.setPassword(sha256.encrypt(createMemberDto.getPassword()));
        createMemberDto.setPhone(aes256.encrypt(createMemberDto.getPhone()));
        // 저장
        MemberEntity memberEntity = modelMapper.map(createMemberDto, MemberEntity.class);
        memberRepository.save(memberEntity);
        CreateMemberDto createdMemberDto = modelMapper.map(memberEntity, CreateMemberDto.class);
        // 전화번호 복호화
        createdMemberDto.setPhone(aes256.decrypt(createdMemberDto.getPhone()));
        return createdMemberDto;
    }

    @Transactional
    public boolean existsByMail(String mail) {
        return memberRepository.existsByMail(mail);
    }
}
