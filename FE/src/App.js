import React from "react";

import GlobalStyle from "@Styles/GlobalStyle";
import Container from "@material-ui/core/Container";

import Header from "@Components/common/Header/Header";
import Issues from "@Pages/Issues";
import Login from "@Pages/Login";
import Labels from "@Pages/Labels";

import { UserProvider } from "@Contexts/userContext";
import { IssueListProvider } from "@Contexts/issueListContext";
import { LabelListProvider } from "@Contexts/labelListContext";

const App = () => {
  return (
    <>
      <GlobalStyle />
      <UserProvider>
        <Header />
        <IssueListProvider>
          <Container maxWidth="lg">
            {/* <Issues /> */}
            <LabelListProvider>
              <Labels />
            </LabelListProvider>
            <Login />
          </Container>
        </IssueListProvider>
      </UserProvider>
    </>
  );
};

export default App;
