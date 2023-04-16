import React, { useState, useEffect, useCallback } from "react";
import * as S from "./index.styled";
import axios from "axios";
import { API_PATH } from "../../../constants/path";
import { useParams } from "react-router-dom";

function MemberAdmin({ id, name, email }) {
  const [data, setData] = useState([]);
  const param = useParams();

  const memberListRequest = useCallback(async () => {
    await axios
      .get(`${API_PATH.ADMIN.MEMBER}`)
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [param]);

  useEffect(() => {
    memberListRequest();
  }, [memberListRequest]);

  return (
    <div>
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
        {data.map((member) => (
              <tr key={member.id}>
                <S.MemberlistTd>{member.id}</S.MemberlistTd>
                <S.MemberlistTd>{member.name}</S.MemberlistTd>
                <S.MemberlistTd>{member.email}</S.MemberlistTd>
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

export default MemberAdmin;