import React, { createContext, useMemo, useReducer } from "react";
import { issuesReducer } from "@Reducers/issuesReducer";

export const initialState = [];

export const IssuesContext = createContext();

export const IssuesProvider = ({ children }) => {
  const [issues, issuesDispatch] = useReducer(issuesReducer, initialState);

  const contextValue = useMemo(
    () => ({
      issues,
      issuesDispatch,
    }),
    [issues],
  );

  return <IssuesContext.Provider value={contextValue}>{children}</IssuesContext.Provider>;
};
