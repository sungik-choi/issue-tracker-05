import React from "react";

import Filter from "./Filter/Filter";

import styled from "styled-components";

const Navigation = () => {
  return (
    <Nav>
      <Filter />
    </Nav>
  );
};

const Nav = styled.nav`
  margin: 50px 0 40px;
`;

export default Navigation;
