package com.multi.shop.auth.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
public class ModifyPasswordRequest {
    private Long memberId;
    private String nowPassword;
    private String newPassword;

    @Builder
    public ModifyPasswordRequest(String nowPassword, String newPassword, String newPasswordCheck) {
        this.memberId = memberId;
        this.nowPassword = nowPassword;
        this.newPassword = newPassword;
    }
}