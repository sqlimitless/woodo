package com.spiderlab.woodo.member.infra;

import com.spiderlab.woodo.member.domain.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    boolean existsByMail(String mail);
}
