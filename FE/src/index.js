import ReactDOM from "react-dom";
import React from "react";
import { CookiesProvider } from "react-cookie";

import App from "./App";

const rootElement = document.getElementById("root");

ReactDOM.render(
  <CookiesProvider>
    <App />
  </CookiesProvider>,
  rootElement,
);
