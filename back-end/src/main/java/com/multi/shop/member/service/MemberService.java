package com.multi.shop.member.service;

import com.multi.shop.member.domain.Password;
import com.multi.shop.member.domain.Phone;
import com.multi.shop.member.domain.vo.MemberFindVO;
import com.multi.shop.auth.dto.request.ModifyPasswordRequest;
import com.multi.shop.member.domain.vo.ModifyPasswordVO;
import com.multi.shop.member.dto.response.MemberFindResponse;
import com.multi.shop.member.domain.vo.MemberVO;
import com.multi.shop.member.dto.request.MemberJoinRequest;
import com.multi.shop.member.exception.MemberErrorCode;
import com.multi.shop.member.exception.MemberException;
import com.multi.shop.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long join(MemberJoinRequest request) {
        validateMemberEmailIsNotDuplicated(request.getEmail());
        validateMemberPhoneIsNotDuplicated(request.getPhone());

        Password password = Password.encode(request.getPassword(), passwordEncoder);
        Phone phone = Phone.of(request.getPhone());

        MemberVO member = MemberVO.of(request, password, phone);

        return memberRepository.save(member);
    }

    private void validateMemberEmailIsNotDuplicated(String email) {
        if (memberRepository.existByMemberEmail(email)) {
            throw new MemberException(MemberErrorCode.JOIN_INVALID_EMAIL);
        }
    }

    private void validateMemberPhoneIsNotDuplicated(String phone) {
        if (memberRepository.existByMemberPhone(phone)) {
            throw new MemberException(MemberErrorCode.JOIN_INVALID_PHONE);
        }
    }

    public MemberFindResponse findByMemberId(String id) {
        MemberFindVO findMember = memberRepository.findByMemberID(id);
        return MemberFindResponse.builder()
                .name(findMember.getName())
                .email(findMember.getEmail())
                .phoneNumber(findMember.getPhoneNumber())
                .build();
    }

    @Transactional
    public String modifyPassword(String id, ModifyPasswordRequest passwordrequest) {


        if (!passwordEncoder.matches(passwordrequest.getNowPassword(), passwordrequest.getNewPassword())) {
            System.out.println("현재 비밀번호와 일치합니다");
        }

        if (passwordEncoder.matches(passwordrequest.getNewPassword(), passwordrequest.getNewPasswordCheck())) {
            System.out.println("비밀번호가 일치하지 않습니다");
        }
        ModifyPasswordVO vo = ModifyPasswordVO.builder().password(passwordrequest.getNewPassword()).build();

        return memberRepository.modifyPassword(id);
    }
}
