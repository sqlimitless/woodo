package com.spiderlab.woodo.member.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "member")
@EntityListeners(AuditingEntityListener.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity {

    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "name")
    private String name;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime regDate;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime modDate;
}
