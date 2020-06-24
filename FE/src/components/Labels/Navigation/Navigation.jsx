import React, { useState, useReducer } from "react";

import Box from "@material-ui/core/Box";

import { labelReducer, initialState, createLabelFetchOptions } from "@Reducers/labelReducer";
import useFetch from "@Hooks/useFetch";
import pipe from "@Utils/pipe";

import CustomButton from "@Components/common/CustomButton";
import LinkButtons from "@Components/common/LinkButtons/LinkButtons";
import NewLabel from "./NewLabel/NewLabel";

const NEW_LABEL_BTN_TEXT = "New Label";

const Navigation = () => {
  const [showNewLabel, setShowNewLabel] = useState(false);
  const [labelState, dispatchLabelState] = useReducer(labelReducer, initialState);

  const toggleNewLabel = () => setShowNewLabel(!showNewLabel);

  const { getData } = pipe(
    createLabelFetchOptions,
    useFetch,
  )({
    data: labelState,
    dispatch: dispatchLabelState,
  });

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
          dispatch={dispatchLabelState}
          submitHandler={getData}
          clickHandler={toggleNewLabel}
        />
      )}
    </>
  );
};

export default Navigation;
