import React from "react";

import GlobalStyle from "@Styles/GlobalStyle";
import Container from "@material-ui/core/Container";

import Header from "@Components/common/Header/Header";
import Issues from "@Pages/Issues";

import { IssueListProvider } from "@Contexts/issueListContext";

const App = () => {
  return (
    <>
      <GlobalStyle />
      <Header />
      <Container maxWidth="lg">
        <IssueListProvider>
          <Issues />
        </IssueListProvider>
      </Container>
    </>
  );
};

export default App;
