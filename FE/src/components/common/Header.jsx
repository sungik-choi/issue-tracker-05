import React from "react";

import styled from "styled-components";

const Header = () => {
  return (
    <HeaderWrap>
      <Title>lssues</Title>
    </HeaderWrap>
  );
};

const HeaderWrap = styled.header`
  display: flex;
  justify-content: center;
  width: 100%;
  height: 55px;
  background-color: #24292e;
  padding: 0 16px;
  line-height: 55px;
`;

const Title = styled.span`
  color: hsla(0, 0%, 100%, 0.7);
  font-weight: 600;
  font-size: 23px;
`;

export default Header;
