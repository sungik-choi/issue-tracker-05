import React, { createContext, useMemo, useReducer } from "react";
import PropTypes from "prop-types";

import { userReducer, initialState } from "@Reducers/userReducer";

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
