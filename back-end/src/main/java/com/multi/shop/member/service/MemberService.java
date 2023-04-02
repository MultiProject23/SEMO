package com.multi.shop.member.service;

import com.multi.shop.member.domain.Password;
import com.multi.shop.member.domain.Phone;
import com.multi.shop.member.domain.vo.MemberFindVO;
import com.multi.shop.auth.dto.request.ModifyPasswordRequest;
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
    public void modifyPassword(ModifyPasswordRequest request) {

        if (!request.getNowPassword().equals(request.getNewPassword())) {

            MemberVO member = memberRepository.findMember(request.getMemberId());

            String encode = passwordEncoder.encode(request.getNowPassword());

            Password password = Password.encode(request.getNewPassword(), passwordEncoder);
            request.setNewPassword(password.getValue());

           memberRepository.modifyPassword(request);
        } else {
            System.out.println("현재 비밀번호와 일치합니다");
        }
    }

    private void confirmPassword(MemberVO member, String encode) {
        if (!passwordEncoder.matches(member.getPassword(), encode)) {
            throw new RuntimeException("현재 비밀번호가 일치하지 않습니다");
        }
    }
}
