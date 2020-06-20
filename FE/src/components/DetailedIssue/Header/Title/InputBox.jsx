import React, { useState } from "react";

import TextField from "@material-ui/core/TextField";
import { data } from "@Mock/detailedIssue";

import { makeStyles } from "@material-ui/core/styles";

const InputBox = ({ title, onChange }) => {
  const classes = useStyles();

  //context로 값 가져오기

  return (
    <form className={classes.input}>
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
    </form>
  );
};

const useStyles = makeStyles((theme) => ({
  input: {
    width: "80%",
  },
}));

export default InputBox;
