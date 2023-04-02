package com.multi.shop.member.mapper;


import com.multi.shop.auth.dto.request.ModifyPasswordRequest;
import com.multi.shop.member.domain.vo.MemberFindVO;
import com.multi.shop.member.domain.vo.MemberVO;

import java.util.Optional;


public interface MemberMapper {
    Long save(MemberVO member);

    Optional<MemberVO> findByMemberEmail(String email);

    boolean existByMemberEmail(String email);

    boolean existByMemberPhone(String phone);

    MemberFindVO findByMemberId(String id);

    void modifyPassword (ModifyPasswordRequest request);

    MemberVO findMember(Long id);
}
