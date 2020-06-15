import React from "react";

import Issues from "@Pages/Issues";
import Header from "@Components/common/Header";

import GlobalStyle from "@Styles/GlobalStyle";

const App = () => {
  return (
    <>
      <GlobalStyle />
      <Header />
      <Issues />
    </>
  );
};

export default App;
