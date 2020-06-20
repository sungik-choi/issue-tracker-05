import React, { useState } from "react";

import TextField from "@material-ui/core/TextField";
import { data } from "@Mock/detailedIssue";

import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";
import { makeStyles } from "@material-ui/core/styles";

const InputBox = ({ title, onChange, onClickSave, onClickClose }) => {
  const SAVE_BTN = "save";
  const CLOSE_BTN = "close";

  const classes = useStyles();

  //context로 값 가져오기

  const textField = (
    <TextField
      id="outlined-full-width"
      style={{ margin: 8 }}
      fullWidth
      margin="normal"
      InputLabelProps={{
        shrink: true,
      }}
      variant="outlined"
      onChange={onChange}
      value={title}
    />
  );

  return (
    <form className={classes.input}>
      {textField}
      <Box display="flex">
        <Button variant="contained" onClick={onClickSave}>
          {SAVE_BTN}
        </Button>
        <Button variant="contained" onClick={onClickClose}>
          {CLOSE_BTN}
        </Button>
      </Box>
    </form>
  );
};

const useStyles = makeStyles((theme) => ({
  input: {
    width: "80%",
  },
}));

export default InputBox;
