import React from "react";

import TextField from "@material-ui/core/TextField";

import { makeStyles } from "@material-ui/core/styles";

const InputBox = () => {
  const classes = useStyles();

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
