import React, { useState } from "react";
import * as S from "./index.styled";

function ProductAdmin({ user_id, name, email }) {
  // 더미데이터
  const data = [
    {
      "user_id": 1,
      "name": "홍길동",
      "email": "project0109@gmail.com",
      },
      {
        "user_id": 2,
        "name": "김기자",
        "email": "project02@gmail.com",
        },
        {
          "user_id": 3,
          "name": "이기자",
          "email": "project03@gmail.com",
          }
  ];
  const [members, setMembers] = useState(data);
  
  return (
    <div>
      <S.Text>회원 현황</S.Text>
      <S.MemberContainer>
        <S.MemberTable>
      <thead>
    <tr>
    <S.StyledTh>신규 회원</S.StyledTh>  
    <S.StyledTh>방문 회원</S.StyledTh>
    <S.StyledTh>전체 회원 수</S.StyledTh>
    </tr>
    </thead>
    <tbody>
    <tr>
    <S.MemberTd>회원</S.MemberTd>
      <S.MemberTd>회원</S.MemberTd>
      <S.MemberTd>회원</S.MemberTd>
    </tr>
    </tbody>
    </S.MemberTable>
      </S.MemberContainer>
        <S.Info>
      신규 회원: 해당 날짜 회원가입 횟수<br/>
      방문 회원: 해당 날짜 로그인 횟수<br/>
      전체 회원 수: 등록된 회원 수
      </S.Info>

          <S.Text>회원 리스트</S.Text>
    <S.MemberlistContainer>
      <S.MemberlistTable>
        <thead>
        <tr>
          <S.StyledTh>회원 ID</S.StyledTh>
          <S.StyledTh>회원 이름</S.StyledTh>
          <S.StyledTh>회원 이메일</S.StyledTh>
          <S.StyledTh>회원 관리</S.StyledTh>
        </tr>
        </thead>
        <tbody>
        {data.map((data, index) => (
              <tr key={index}>
                <S.MemberlistTd>{data.user_id}</S.MemberlistTd>
                <S.MemberlistTd>{data.name}</S.MemberlistTd>
                <S.MemberlistTd>{data.email}</S.MemberlistTd>
                <S.MemberlistTd>
                  <input type="checkbox" />
                </S.MemberlistTd>
              </tr>
            ))}
        <tr>
        <td colSpan={3}>
        </td>
        <S.Footer><S.Button>삭제</S.Button></S.Footer>
        </tr>
        </tbody>
      </S.MemberlistTable>
    </S.MemberlistContainer>
    </div>
  );
}

export default ProductAdmin;