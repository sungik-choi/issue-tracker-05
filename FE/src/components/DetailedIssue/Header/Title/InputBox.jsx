import React, { useState } from "react";

import TextField from "@material-ui/core/TextField";
import { data } from "@Mock/detailedIssue";

import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";
import ButtonGroup from "@material-ui/core/ButtonGroup";
import { makeStyles } from "@material-ui/core/styles";

const InputBox = ({ title, onChange, onClickSave, onClickClose }) => {
  const SAVE_BTN = "save";
  const CLOSE_BTN = "close";

  const classes = useStyles();

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
      <Box display="flex" alignItems="center" justifyContent="space-between">
        {textField}
        <ButtonGroup>
          <Button variant="contained" onClick={onClickSave} className={classes.button}>
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
  input: {
    width: "100%",
  },
  button: {
    marginLeft: theme.spacing(6),
    marginRight: theme.spacing(2),
  },
}));

export default InputBox;
