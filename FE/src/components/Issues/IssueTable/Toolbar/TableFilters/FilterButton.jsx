import React from "react";
import PropTypes from "prop-types";

import Button from "@material-ui/core/Button";
import ArrowDropDownIcon from "@material-ui/icons/ArrowDropDown";

const FilterButton = ({ text }) => {
  return (
    <Button aria-controls={text}>
      {text}
      <ArrowDropDownIcon />
    </Button>
  );
};

FilterButton.propTypes = {
  text: PropTypes.string.isRequired,
};

export default FilterButton;
