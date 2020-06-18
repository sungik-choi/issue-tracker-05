import React, { createContext, useReducer } from "react";

const initialState = { count: 0 };
export const store = createContext(initialState);
const { Provider } = store;

const reducer = (state, action) => {
  switch (action.type) {
    case "action description":
      return state.count++;
    default:
      throw new Error();
  }
};

const StateProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);
  return <Provider value={{ state, dispatch }}>{clidren}</Provider>;
};

console.log(store);

export default StateProvider;
