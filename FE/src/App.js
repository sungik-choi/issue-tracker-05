import React from "react";

import GlobalStyle from "@Styles/GlobalStyle";
import Container from "@material-ui/core/Container";

import Header from "@Components/common/Header/Header";
import Issues from "@Pages/Issues";
import DetailedIssue from "@Pages/DetailedIssue";

import { UserProvider } from "@Contexts/userContext";
import { IssueListProvider } from "@Contexts/issueListContext";

const App = () => {
  return (
    <>
      <GlobalStyle />
      <UserProvider>
        <Header />
        <Container maxWidth="lg">
          <IssueListProvider>
            <Issues />
          </IssueListProvider>
        </Container>
      </UserProvider>
    </>
  );
};

export default App;
