package com.multi.shop.member.service;

import com.multi.shop.auth.dto.request.MemberJoinRequest;
import com.multi.shop.member.domain.Password;
import com.multi.shop.member.domain.Phone;
import com.multi.shop.member.domain.dao.MemberJoinDAO;
import com.multi.shop.member.domain.vo.MemberFindVO;
import com.multi.shop.member.dto.response.MemberFindResponse;
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

        MemberJoinDAO dao = MemberJoinDAO.builder()
                .brith(request.getBirth())
                .email(request.getEmail())
                .name(request.getName())
                .password(password.getValue())
                .phone(phone.getValue())
                .build();
        return memberRepository.save(dao);
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
        return MemberFindResponse.builder().name(findMember.getName()).email(findMember.getEmail()).phoneNumber(findMember.getPhoneNumber()).build();
    }
}
