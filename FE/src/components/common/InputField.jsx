import React from "react";

import TextField from "@material-ui/core/TextField";

const InputField = ({
  value,
  onChange,
  fullWidth = true,
  id = "outlined-full-width",
  ...props
}) => {
  return (
    <TextField
      id={id}
      fullWidth={fullWidth}
      margin="normal"
      InputLabelProps={{
        shrink: true,
      }}
      variant="outlined"
      onChange={onChange}
      value={value}
      {...props}
    />
  );
};

export default InputField;
