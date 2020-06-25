import React, { useState, useReducer } from "react";
import PropTypes from "prop-types";
import { useCookies } from "react-cookie";
import useFetch from "@Hooks/useFetch";
import pipe from "@Utils/pipe";

import Box from "@material-ui/core/Box";

import { labelReducer, initialState, createLabelFetchOptions } from "@Reducers/labelReducer";

import CustomButton from "@Components/common/CustomButton";
import LinkButtons from "@Components/common/LinkButtons/LinkButtons";

import { TOKEN } from "@Constants/constants";

import NewLabel from "./NewLabel/NewLabel";

const NEW_LABEL_BTN_TEXT = "New Label";

const Navigation = ({ reFetch }) => {
  const [{ token }] = useCookies([TOKEN]);
  const [showNewLabel, setShowNewLabel] = useState(false);
  const [labelState, labelStateDispatch] = useReducer(labelReducer, initialState);

  const toggleNewLabel = () => setShowNewLabel(!showNewLabel);

  const { getData } = pipe(
    createLabelFetchOptions,
    useFetch,
  )({
    data: labelState,
    dispatch: labelStateDispatch,
    token,
  });

  const submitHandler = () => pipe(getData, reFetch)();

  return (
    <>
      <Box
        component="nav"
        mt={14}
        mb={2}
        maxHeight={38}
        display="flex"
        justifyContent="space-between"
      >
        <LinkButtons activeButton="labels" />
        <CustomButton text={NEW_LABEL_BTN_TEXT} clickHandler={toggleNewLabel} />
      </Box>
      {showNewLabel && (
        <NewLabel
          state={labelState}
          dispatch={labelStateDispatch}
          submitHandler={submitHandler}
          clickHandler={toggleNewLabel}
        />
      )}
    </>
  );
};

Navigation.propTypes = {
  reFetch: PropTypes.func.isRequired,
};

export default Navigation;
