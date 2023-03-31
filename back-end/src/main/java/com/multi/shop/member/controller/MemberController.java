package com.multi.shop.member.controller;

import com.multi.shop.auth.dto.request.MemberJoinRequest;
import com.multi.shop.member.dto.response.MemberFindResponse;
import com.multi.shop.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<Void> join(@RequestBody @Valid MemberJoinRequest request) {
        memberService.join(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/auth/member")
    public ResponseEntity<MemberFindResponse> findMember(@Param("memberId") String id) {
        MemberFindResponse response = memberService.findByMemberId(id);
        return ResponseEntity.ok().body(response);
    }
}
