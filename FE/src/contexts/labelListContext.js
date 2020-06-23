import React, { createContext, useMemo, useReducer } from "react";
import PropTypes from "prop-types";

import { labelListReducer } from "@Reducers/labelListReducer";

export const initialState = {
  labelInfo: null,
};

export const LabelListContext = createContext();

export const LabelListProvider = ({ children }) => {
  const [labelList, labelListDispatch] = useReducer(labelListReducer, initialState);

  const contextValue = useMemo(
    () => ({
      labelList,
      labelListDispatch,
    }),
    [labelList, labelListDispatch],
  );

  return <LabelListContext.Provider value={contextValue}>{children}</LabelListContext.Provider>;
};

LabelListProvider.propTypes = {
  children: PropTypes.oneOfType([PropTypes.arrayOf(PropTypes.node), PropTypes.node]).isRequired,
};
