package com.multi.shop.member.repository;


import com.multi.shop.auth.dto.request.ModifyPasswordRequest;
import com.multi.shop.member.domain.vo.MemberFindVO;
import com.multi.shop.member.domain.vo.MemberVO;
import com.multi.shop.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MemberRepository {
    private final MemberMapper memberMapper;

    public Long save(MemberVO member) {
        return memberMapper.save(member);
    }

    public Optional<MemberVO> findByMemberEmail(String email) {
        return memberMapper.findByMemberEmail(email);
    }

    public boolean existByMemberEmail(String email) {
        return memberMapper.existByMemberEmail(email);
    }

    public boolean existByMemberPhone(String phone) {
        return memberMapper.existByMemberPhone(phone);
    }

    public MemberFindVO findByMemberID(String id) { return memberMapper.findByMemberId(id); }

    public void modifyPassword (ModifyPasswordRequest request) { memberMapper.modifyPassword(request); }

    public MemberVO findMember(Long id) { return memberMapper.findMember(id); }
}
