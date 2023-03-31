package com.multi.shop.member.domain.vo;

import com.multi.shop.member.domain.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MemberVO {
    private Long id;
    private LocalDate birth;
    private String email;
    private String name;
    private String password;
    private String phone;
    private Role role;

    @Builder
    public MemberVO(Long id, LocalDate birth, String email, String name, String password, String phone, Role role) {
        this.id = id;
        this.birth = birth;
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }
}