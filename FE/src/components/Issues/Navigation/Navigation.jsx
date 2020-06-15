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
  border: 1px solid red;
`;

export default Navigation;
