import React, { createContext, useMemo, useReducer } from "react";
import PropTypes from "prop-types";

import { userReducer } from "@Reducers/userReducer";

// ! Mock User Data

export const initialState = {
  id: "sungik-choi",
  avatarUrl:
    "https://lh3.googleusercontent.com/lv3q0LxixvhfsBwhLKzpp53EPMQO92jq98uOKqT9sL0hv4gF8l9bl6SRN23FLxkeJH3ldxZt-PreP1zddg",
};

export const UserContext = createContext();

export const UserProvider = ({ children }) => {
  const [user, userDispatch] = useReducer(userReducer, initialState);

  const contextValue = useMemo(
    () => ({
      user,
      userDispatch,
    }),
    [user],
  );

  return <UserContext.Provider value={contextValue}>{children}</UserContext.Provider>;
};

UserProvider.propTypes = {
  children: PropTypes.oneOfType([PropTypes.arrayOf(PropTypes.node), PropTypes.node]).isRequired,
};
