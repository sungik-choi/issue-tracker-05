import React from "react";
import PropTypes from "prop-types";

import Button from "@material-ui/core/Button";

const PrimaryButton = ({ text, clickHandler }) => {
  return (
    <Button variant="contained" color="primary" disableElevation onClick={clickHandler}>
      {text}
    </Button>
  );
};

PrimaryButton.propTypes = {
  text: PropTypes.string.isRequired,
  clickHandler: PropTypes.func.isRequired,
};

export default PrimaryButton;
