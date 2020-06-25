import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import { CookiesProvider } from "react-cookie";
import { UserProvider } from "@Contexts/userContext";

import App from "./App";

const rootElement = document.getElementById("root");

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <CookiesProvider>
        <UserProvider>
          <App />
        </UserProvider>
      </CookiesProvider>
    </BrowserRouter>
  </React.StrictMode>,
  rootElement,
);
