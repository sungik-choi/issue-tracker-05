import { useState, useContext, useEffect } from "react";
import { useCookies } from "react-cookie";
import jwtDecode from "jwt-decode";
import pipe from "@Utils/pipe";

import { UserContext } from "@Contexts/userContext";
import { setUserData } from "@Reducers/userReducer";

import { TOKEN } from "@Constants/constants";

const useAuth = () => {
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
