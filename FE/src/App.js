import React from "react";

import GlobalStyle from "@Styles/GlobalStyle";
import Header from "@Components/common/Header";
import Issues from "@Pages/Issues";
import Navigation from "@Components/Issues/Navigation/Navigation";
import ClearButton from "@Components/Issues/ClearButton";
import Container from "@material-ui/core/Container";

const App = () => {
  return (
    <>
      <GlobalStyle />
      <Header />
      <Container maxWidth="lg">
        <Navigation />
        <ClearButton />
        <Issues />
      </Container>
    </>
  );
};

export default App;
