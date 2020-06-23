import React from "react";
import PropTypes from "prop-types";

import Button from "@material-ui/core/Button";

const CustomButton = ({ color, text, clickHandler, ...props }) => {
  return (
    <Button variant="contained" color={color} disableElevation onClick={clickHandler} {...props}>
      {text}
    </Button>
  );
};

CustomButton.defaultProps = {
  clickHandler: null,
  color: "primary",
};

CustomButton.propTypes = {
  color: PropTypes.string,
  text: PropTypes.string.isRequired,
  clickHandler: PropTypes.oneOfType([PropTypes.func, PropTypes.instanceOf(null)]),
};

export default CustomButton;
