import React from "react";

import Header from "./components/common/Header";
import Navigation from "./components/Issues/Navigation/Navigation";

import GlobalStyle from "./style/GlobalStyle";

const App = () => {
  return (
    <>
      <GlobalStyle />
      <Header />
      <Navigation />
    </>
  );
};

export default App;
