import { useState, useContext, useEffect } from "react";
import { useCookies } from "react-cookie";
import jwtDecode from "jwt-decode";
import pipe from "@Utils/pipe";

import { UserContext } from "@Contexts/userContext";
import { setUserData } from "@Reducers/userReducer";

import { TOKEN } from "@Constants/constants";

const useAuth = () => {
  document.cookie =
    "token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdmF0YXJVcmwiOiJodHRwczovL2F2YXRhcnMyLmdpdGh1YnVzZXJjb250ZW50LmNvbS91LzU4MjA5MDA5P3Y9NCIsIm5hbWUiOiJTdW5naWsgQ2hvaSIsImlkIjo1ODIwOTAwOSwiZXhwIjoxNTkzMDQ1MDI5fQ.u8oD16_vVEfNumcueeZy2Re-FUMIVb-DLNTcdeDShz8";

  const [{ token }] = useCookies([TOKEN]);
  const { userDispatch } = useContext(UserContext);
  const [isAuthenticated, setIsAuthenticated] = useState(!!token);

  const setToken = () => pipe(jwtDecode, setUserData, userDispatch)(token);

  useEffect(
    () => {
      if (token) setToken();
    },
    // eslint-disable-next-line
    [],
  );
  return { isAuthenticated, token };
};

export default useAuth;
