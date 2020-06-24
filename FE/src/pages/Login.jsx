import React, { useContext, useEffect } from "react";
import jwtDecode from "jwt-decode";
import { useCookies } from "react-cookie";
import pipe from "@Utils/pipe";

import { UserContext } from "@Contexts/userContext";
import { setUserData } from "@Reducers/userReducer";

import LoginForm from "@Components/Login/LoginForm";

import { TOKEN } from "@Constants/constants";

const Login = () => {
  document.cookie =
    "token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdmF0YXJVcmwiOiJodHRwczovL2F2YXRhcnMyLmdpdGh1YnVzZXJjb250ZW50LmNvbS91LzU4MjA5MDA5P3Y9NCIsIm5hbWUiOiJTdW5naWsgQ2hvaSIsImlkIjo1ODIwOTAwOSwiZXhwIjoxNTkzMDQ1MDI5fQ.u8oD16_vVEfNumcueeZy2Re-FUMIVb-DLNTcdeDShz8";
  const [cookies] = useCookies([TOKEN]);
  const { token } = cookies;

  const { userDispatch } = useContext(UserContext);

  useEffect(
    () => pipe(jwtDecode, setUserData, userDispatch)(token),
    // eslint-disable-next-line react-hooks/exhaustive-deps
    [],
  );

  return <LoginForm />;
};

export default Login;
