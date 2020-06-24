import { labelsUrl } from "@Utils/urls";

import generateRandomColor from "@Utils/generateRandomColor";

export const initialState = {
  title: "",
  description: "",
  ...generateRandomColor(),
};

export const FETCH_SUCCESS = "FETCH_SUCCESS";
export const FETCH_ERROR = "FETCH_ERROR";
export const SET_LABEL_COLOR = "SET_LABEL_COLOR";
export const SET_LABEL_INFO = "SET_LABEL_INFO";

export const fetchSuccess = () => {
  return { type: FETCH_SUCCESS };
};

export const fetchError = () => {
  return { type: FETCH_ERROR };
};

export const setLabelColor = () => {
  return { type: SET_LABEL_COLOR };
};

export const setLabelInfo = (payload) => {
  return { type: SET_LABEL_INFO, payload };
};

export const labelReducer = (state, action) => {
  const { type, payload } = action;

  switch (type) {
    case SET_LABEL_COLOR:
      return { ...state, ...generateRandomColor() };
    case SET_LABEL_INFO:
      return { ...state, ...payload };
    case FETCH_SUCCESS:
      return { ...initialState, ...generateRandomColor() };
    case FETCH_ERROR:
      return { ...initialState, ...generateRandomColor() };
    default:
      return state;
  }
};

export const createLabelFetchOptions = ({ data, dispatch, token }) => ({
  url: labelsUrl,
  dispatch,
  actionType: {
    fetchSuccess,
    fetchError,
  },
  option: {
    method: "POST",
    body: JSON.stringify(data),
    headers: {
      "Content-Type": "application/json",
      Authorization: token,
    },
  },
  skip: true,
});
