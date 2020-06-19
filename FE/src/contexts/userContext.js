import React, { createContext, useMemo, useReducer } from "react";
import { issuesReducer } from "@Reducers/issuesReducer";

export const initialState = {};

export const UserContext = createContext();

export const UserProvider = ({ children }) => {
  const [user, userDispatch] = useReducer(issuesReducer, initialState);

  const contextValue = useMemo(
    () => ({
      user,
      userDispatch,
    }),
    [user],
  );

  return <UserContext.Provider value={contextValue}>{children}</UserContext.Provider>;
};
