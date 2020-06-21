import React from "react";
import PropTypes from "prop-types";

import TextField from "@material-ui/core/TextField";

const InputField = ({ value, onChange, fullWidth, id, ...props }) => {
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

InputField.defaultProps = {
  fullWidth: true,
  id: "outlined-full-width",
  value: "",
  onChange: null,
};

InputField.propTypes = {
  value: PropTypes.string,
  onChange: PropTypes.oneOfType([PropTypes.func, PropTypes.instanceOf(null)]),
  id: PropTypes.string,
  fullWidth: PropTypes.boolen,
};

export default InputField;
