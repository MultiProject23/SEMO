package com.multi.shop.member.dto.response;

import lombok.Builder;
import lombok.Data;

@Data

public class MemberFindResponse {
    private String name;
    private String email;
    private String phoneNumber;

    @Builder
    public MemberFindResponse(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
