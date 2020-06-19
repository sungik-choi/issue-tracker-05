import React from "react";

import GlobalStyle from "@Styles/GlobalStyle";
import Container from "@material-ui/core/Container";

import Header from "@Components/common/Header/Header";
import Issues from "@Pages/Issues";

import { IssuesProvider } from "@Contexts/issuesContext";

const App = () => {
  return (
    <>
      <IssuesProvider>
        <GlobalStyle />
        <Header />
        <Container maxWidth="lg">
          <Issues />
        </Container>
      </IssuesProvider>
    </>
  );
};

export default App;
