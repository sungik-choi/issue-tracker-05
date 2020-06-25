export const initialState = {
  id: null,
  exp: null,
  name: "",
  avatarUrl: "",
};

export const SET_USER_DATA = "SET_USER_DATA";
export const DELETE_USER_DATA = "DELETE_USER_DATA";

export const setUserData = (payload) => {
  return { type: SET_USER_DATA, payload };
};

export const deleteUserData = () => {
  return { type: DELETE_USER_DATA };
};

export const userReducer = (state, action) => {
  const { type, payload } = action;

  switch (type) {
    case SET_USER_DATA:
      return { ...state, ...payload };
    case DELETE_USER_DATA:
      return { ...initialState };
    default:
      return state;
  }
};
