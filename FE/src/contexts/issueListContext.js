import React, { createContext, useMemo, useReducer } from "react";
import PropTypes from "prop-types";

import { issueListReducer } from "@Reducers/issueListReducer";

export const initialState = {
  issues: null,
  labelInfo: null,
  milestoneInfo: null,
  users: null,
};

export const IssueListContext = createContext();

export const IssueListProvider = ({ children }) => {
  const [issueList, issueListDispatch] = useReducer(issueListReducer, initialState);

  const contextValue = useMemo(
    () => ({
      issueList,
      issueListDispatch,
    }),
    [issueList, issueListDispatch],
  );

  return <IssueListContext.Provider value={contextValue}>{children}</IssueListContext.Provider>;
};

IssueListProvider.propTypes = {
  children: PropTypes.oneOfType([PropTypes.arrayOf(PropTypes.node), PropTypes.node]).isRequired,
};
