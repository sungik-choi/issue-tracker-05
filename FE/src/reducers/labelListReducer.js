export const initialState = {
  labelInfo: null,
};

export const FETCH_SUCCESS = "FETCH_SUCCESS";
export const FETCH_ERROR = "FETCH_ERROR";
export const CREATE_LABEL = "CREATE_LABEL";
export const EDIT_LABEL = "EDIT_LABEL";
export const DELETE_LABEL = "DELETE_LABEL";

export const fetchSuccess = (payload) => {
  return { type: FETCH_SUCCESS, payload };
};

export const fetchError = () => {
  return { type: FETCH_ERROR };
};

export const createLabel = (payload) => {
  return { type: CREATE_LABEL, payload };
};

export const editLabel = (payload) => {
  return { type: EDIT_LABEL, payload };
};

export const deleteLabel = (payload) => {
  return { type: DELETE_LABEL, payload };
};

export const labelListReducer = (state, action) => {
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
