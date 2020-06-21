import React from "react";
import PropTypes from "prop-types";

import Button from "@material-ui/core/Button";

const PrimaryButton = ({ text, clickHandler, color, ...props }) => {
  return (
    <Button variant="contained" color={color} disableElevation onClick={clickHandler} {...props}>
      {text}
    </Button>
  );
};

PrimaryButton.defaultProps = {
  color: "primary",
  clickHandler: null,
};

PrimaryButton.propTypes = {
  text: PropTypes.string.isRequired,
  color: PropTypes.string,
  clickHandler: PropTypes.oneOfType([PropTypes.func, PropTypes.instanceOf(null)]),
};

export default PrimaryButton;
