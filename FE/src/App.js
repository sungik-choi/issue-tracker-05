import React from "react";

import Header from "./components/common/Header";
import Navigation from "./components/Issues/Navigation/Navigation";

import GlobalStyle from "./style/GlobalStyle";
import styled from "styled-components";

const App = () => {
  return (
    <>
      <GlobalStyle />
      <Header />
      <MainWrap>
        <Navigation />
      </MainWrap>
    </>
  );
};

const MainWrap = styled.div`
  margin: 0 auto;
  width: 80%;
`;

export default App;
