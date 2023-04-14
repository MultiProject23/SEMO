import React, { useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import * as S from "./index.styled";
import MemberAdmin from "../MemberAdmin";
import ProductAdmin from "../ProductAdmin";

function MenuTabs() {
  const location = useLocation();
  const path = location.pathname;
  const member = path.includes("member");
  const product = path.includes("product");
  const navigate = useNavigate();
  
  useEffect(() => {
    if (!member && !product) {
      navigate("/admin/member", { replace: true });
    }
  }, [member, product, navigate]);

  var element;
  if (member) {
    element = <MemberAdmin />;
  } 
  if (product) {
    element = <ProductAdmin />;
  }

  return (
    <>
      <S.Container>
        <S.StyledLink to="/admin/member">
          <S.Text>회원 관리</S.Text>
        </S.StyledLink>
        <S.StyledLink to="/admin/product">
          <S.Text>상품 관리</S.Text>
        </S.StyledLink>
      </S.Container>
      {element}
    </>
  );
}

export default MenuTabs;
