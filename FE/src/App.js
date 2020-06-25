import React from "react";
import { Switch, Route } from "react-router-dom";
import useAuth from "@Hooks/useAuth";

import GlobalStyle from "@Styles/GlobalStyle";
import Container from "@material-ui/core/Container";

import Header from "@Components/common/Header/Header";

import AuthRoute from "@Pages/AuthRoute";
import Issues from "@Pages/Issues";
import Login from "@Pages/Login";
import Labels from "@Pages/Labels";

import { UserProvider } from "@Contexts/userContext";
import { IssueListProvider } from "@Contexts/issueListContext";
import { LabelListProvider } from "@Contexts/labelListContext";

const App = () => {
  const { isAuthenticated } = useAuth();

  return (
    <>
      <GlobalStyle />
      <Header />
      <Container maxWidth="lg">
        <Switch>
          <Route path="/login">
            <Login isAuthenticated={isAuthenticated} />
          </Route>
          <AuthRoute path={["/", "/issues"]} exact isAuthenticated={isAuthenticated}>
            <IssueListProvider>
              <Issues />
            </IssueListProvider>
          </AuthRoute>
          <AuthRoute path="/labels" isAuthenticated={isAuthenticated}>
            <LabelListProvider>
              <Labels />
            </LabelListProvider>
          </AuthRoute>
        </Switch>
      </Container>
    </>
  );
};

export default App;
