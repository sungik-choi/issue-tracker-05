import React, { useContext, useEffect } from "react";

import jwtDecode from "jwt-decode";
import { useCookies } from "react-cookie";

import { UserContext } from "@Contexts/userContext";
import { setUserData } from "@Reducers/userReducer";

import LoginForm from "@Components/Login/LoginForm";

const TOKEN = "token";

const Login = () => {
  document.cookie =
    "token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdmF0YXJVcmwiOiJodHRwczovL2F2YXRhcnMyLmdpdGh1YnVzZXJjb250ZW50LmNvbS91LzU4MjA5MDA5P3Y9NCIsIm5hbWUiOiJTdW5naWsgQ2hvaSIsImlkIjo1ODIwOTAwOSwiZXhwIjoxNTkzMDQ1MDI5fQ.u8oD16_vVEfNumcueeZy2Re-FUMIVb-DLNTcdeDShz8";
  const [cookies, setCookies] = useCookies([TOKEN]);
  const { token } = cookies;

  const { userDispatch } = useContext(UserContext);

  useEffect(() => {
    const decodedToken = jwtDecode(token);
    userDispatch(setUserData(decodedToken));
  }, []);

  return <LoginForm />;
};

export default Login;
