import React from "react";

import GlobalStyle from "@Styles/GlobalStyle";
import Header from "@Components/common/Header/Header";
import Issues from "@Pages/Issues";
import DetailedIssue from "@Pages/DetailedIssue";
import Container from "@material-ui/core/Container";

const App = () => {
  return (
    <>
      <GlobalStyle />
      <Header />
      <Container maxWidth="lg">
        <Issues />
      </Container>
    </>
  );
};

export default App;
