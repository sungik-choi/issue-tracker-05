import React from "react";

import GlobalStyle from "@Styles/GlobalStyle";
import Container from "@material-ui/core/Container";

import Header from "@Components/common/Header/Header";
import Issues from "@Pages/Issues";
import DetailedIssue from "@Pages/DetailedIssue";
import Login from "@Pages/Login";

import { UserProvider } from "@Contexts/userContext";
import { IssueListProvider } from "@Contexts/issueListContext";
import { DetailedIssueProvider } from "@Contexts/detailedIssueContext";

const App = () => {
  return (
    <>
      <GlobalStyle />
      <UserProvider>
        <Header />
        <IssueListProvider>
          <Container maxWidth="lg">
            {/* <Issues /> */}
            {/* <Login /> */}
            <DetailedIssueProvider>
              <DetailedIssue />
            </DetailedIssueProvider>
          </Container>
        </IssueListProvider>
      </UserProvider>
    </>
  );
};

export default App;
