import generateRandomColor from "@Utils/generateRandomColor";

export const initialState = {
  title: "",
  description: "",
  ...generateRandomColor(),
};

export const SET_LABEL_COLOR = "SET_LABEL_COLOR";
export const SET_LABEL_INFO = "SET_LABEL_INFO";

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
    default:
      return state;
  }
};
