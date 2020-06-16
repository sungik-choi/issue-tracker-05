import React from "react";

import Header from "./components/common/Header";
import Navigation from "./components/Issues/Navigation/Navigation";

import GlobalStyle from "./style/GlobalStyle";
import Container from "@material-ui/core/Container";

const App = () => {
  return (
    <>
      <GlobalStyle />
      <Header />
      <Container maxWidth="lg">
        <Navigation />
      </Container>
    </>
  );
};

export default App;
