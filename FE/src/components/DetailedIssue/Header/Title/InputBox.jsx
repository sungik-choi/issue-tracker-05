import React, { useState } from "react";

import InputField from "@Components/Common/InputField";

import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";
import ButtonGroup from "@material-ui/core/ButtonGroup";
import { makeStyles } from "@material-ui/core/styles";

const InputBox = ({ title, onChange, onClickSave, onClickClose }) => {
  const SAVE_BTN = "save";
  const CLOSE_BTN = "close";

  const classes = useStyles();

  const onSubmitForm = (e) => {
    e.preventDefault();
    onClickSave();
  };

  return (
    <form onSubmit={onSubmitForm}>
      <Box display="flex" alignItems="center" justifyContent="space-between">
        <InputField
          onChange={onChange}
          value={title}
          inputProps={{ "aria-label": "Issue title" }}
        />
        <ButtonGroup>
          <Button variant="contained" type="submit" value="Submit" className={classes.button}>
            {SAVE_BTN}
          </Button>
          <Button variant="contained" onClick={onClickClose}>
            {CLOSE_BTN}
          </Button>
        </ButtonGroup>
      </Box>
    </form>
  );
};

const useStyles = makeStyles((theme) => ({
  button: {
    marginLeft: theme.spacing(6),
    marginRight: theme.spacing(2),
  },
}));

export default InputBox;
