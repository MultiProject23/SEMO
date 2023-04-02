package com.multi.shop.auth.dto.request;
import lombok.Builder;
import lombok.Data;

@Data
public class ModifyPasswordRequest {
    private String nowPassword;
    private String newPassword;
    private String newPasswordCheck;

    @Builder
    public ModifyPasswordRequest(String nowPassword, String newPassword, String newPasswordCheck) {
        this.nowPassword = nowPassword;
        this.newPassword = newPassword;
        this.newPasswordCheck = newPasswordCheck;
    }
}