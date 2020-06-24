import React from "react";
import PropTypes from "prop-types";

import TextField from "@material-ui/core/TextField";

const InputField = ({ onChange, fullWidth, id, ...props }) => {
  return (
    <TextField
      id={id}
      fullWidth={fullWidth}
      margin="normal"
      variant="outlined"
      onChange={onChange}
      {...props}
    />
  );
};

InputField.defaultProps = {
  fullWidth: true,
  id: "outlined-full-width",
  onChange: null,
};

InputField.propTypes = {
  onChange: PropTypes.oneOfType([PropTypes.func, PropTypes.instanceOf(null)]),
  id: PropTypes.string,
  fullWidth: PropTypes.bool,
};

export default InputField;
