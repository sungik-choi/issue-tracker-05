import { issuesUrl } from "@Utils/urls";

export const initialState = {
  issues: null,
  labelInfo: null,
  milestoneInfo: null,
  users: null,
};

export const FETCH_SUCCESS = "FETCH_SUCCESS";
export const FETCH_ERROR = "FETCH_ERROR";

export const fetchSuccess = (payload) => {
  return { type: FETCH_SUCCESS, payload };
};

export const fetchError = () => {
  return { type: FETCH_ERROR };
};

export const issueListReducer = (state, action) => {
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

export const getInitialData = (dispatch) => ({
  url: issuesUrl,
  dispatch,
  actionType: {
    successAction: fetchSuccess,
    errorAction: fetchError,
  },
  option: {
    method: "GET",
  },
});
