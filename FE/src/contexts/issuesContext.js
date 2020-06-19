import React, { createContext, useMemo, useReducer } from "react";
import { issuesReducer } from "@Reducers/issuesReducer";

export const initialState = [];

export const IssueListContext = createContext();

export const IssueListProvider = ({ children }) => {
  const [issueList, issueListDispatch] = useReducer(issuesReducer, initialState);

  const contextValue = useMemo(
    () => ({
      issueList,
      issueListDispatch,
    }),
    [issueList, issueListDispatch],
  );

  return <IssueListContext.Provider value={contextValue}>{children}</IssueListContext.Provider>;
};
