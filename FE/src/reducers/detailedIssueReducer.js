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

export const detailedIssueReducer = (state, action) => {
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

export const detailedIssueFetchOptions = (dispatch) => ({
  url: issuesUrl,
  dispatch,
  actionType: {
    fetchSuccess,
    fetchError,
  },
  option: {
    method: "GET",
  },
});
