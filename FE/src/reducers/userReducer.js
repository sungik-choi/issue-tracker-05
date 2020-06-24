export const initialState = {
  id: "sungik-choi",
  avatarUrl:
    "https://lh3.googleusercontent.com/lv3q0LxixvhfsBwhLKzpp53EPMQO92jq98uOKqT9sL0hv4gF8l9bl6SRN23FLxkeJH3ldxZt-PreP1zddg",
};

export const FETCH_SUCCESS = "FETCH_SUCCESS";
export const FETCH_ERROR = "FETCH_ERROR";

export const fetchSuccess = (payload) => {
  return { type: FETCH_SUCCESS, payload };
};

export const fetchError = () => {
  return { type: FETCH_ERROR };
};

export const userReducer = (state, action) => {
  const { type, payload } = action;

  switch (type) {
    case FETCH_SUCCESS:
      return { ...state, ...payload };
    case FETCH_ERROR:
      return { ...state };
    default:
      return state;
  }
};
