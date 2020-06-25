import React, { createContext, useMemo, useReducer } from "react";
import PropTypes from "prop-types";

import { detailedIssueReducer, initialState } from "@Reducers/detailedIssueReducer";

export const DetailedIssueContext = createContext();

export const DetailedIssueProvider = ({ children }) => {
  const [detailedIssue, detailedIssueDispatch] = useReducer(detailedIssueReducer, initialState);

  const contextValue = useMemo(
    () => ({
      detailedIssue,
      detailedIssueDispatch,
    }),
    [detailedIssue, detailedIssueDispatch],
  );

  return (
    <DetailedIssueContext.Provider value={contextValue}>{children}</DetailedIssueContext.Provider>
  );
};

DetailedIssueProvider.propTypes = {
  children: PropTypes.oneOfType([PropTypes.arrayOf(PropTypes.node), PropTypes.node]).isRequired,
};
