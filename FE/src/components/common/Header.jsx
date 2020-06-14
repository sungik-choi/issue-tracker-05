import React from "react";

import styled from "styled-components";
import CollectionsBookmarkIcon from "@material-ui/icons/CollectionsBookmark";

const Header = () => {
  return (
    <HeaderWrap>
      <BookIcon>
        <CollectionsBookmarkIcon fontSize="small" />
      </BookIcon>
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
  font-size: 20px;
`;

const BookIcon = styled(Title)`
  padding: 0 5px;
`;

export default Header;
