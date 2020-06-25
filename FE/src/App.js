import React from "react";

import GlobalStyle from "@Styles/GlobalStyle";
import Container from "@material-ui/core/Container";

import Header from "@Components/common/Header/Header";

import Issues from "@Pages/Issues";
import DetailedIssue from "@Pages/DetailedIssue";
import Login from "@Pages/Login";
import Labels from "@Pages/Labels";

import { UserProvider } from "@Contexts/userContext";
import { IssueListProvider } from "@Contexts/issueListContext";
import { DetailedIssueProvider } from "@Contexts/detailedIssueContext";
import { LabelListProvider } from "@Contexts/labelListContext";

const App = () => {
  return (
    <>
      <GlobalStyle />
      <UserProvider>
        <Header />
        <Container maxWidth="lg">
          {/* <IssueListProvider><Issues /></IssueListProvider> */}
          <LabelListProvider>
            <Labels />
          </LabelListProvider>
          <DetailedIssueProvider>
              <DetailedIssue />
          </DetailedIssueProvider>
          {/* <Login /> */}
        </Container>
      </UserProvider>
    </>
  );
};

export default App;
