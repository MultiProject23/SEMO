package com.multi.shop.member.domain.vo;

import lombok.Builder;
import lombok.Data;

@Data
public class ModifyPasswordVO {
    private String id;
    private String password;

    @Builder
    public ModifyPasswordVO(String id, String password) {
        this.id = id;
        this.password = password;
    }
}

