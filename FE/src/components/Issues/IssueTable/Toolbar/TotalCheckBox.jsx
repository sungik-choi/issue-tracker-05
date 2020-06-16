import React from "react";
import PropTypes from "prop-types";

import Checkbox from "@material-ui/core/Checkbox";

const TotalCheckbox = ({ bIndeterminate, bChecked, clickHandler }) => {
  return (
    <Checkbox
      color="primary"
      indeterminate={bIndeterminate}
      checked={bChecked}
      onChange={clickHandler}
    />
  );
};

TotalCheckbox.propTypes = {
  bIndeterminate: PropTypes.bool.isRequired,
  bChecked: PropTypes.bool.isRequired,
  clickHandler: PropTypes.func.isRequired,
};

export default TotalCheckbox;
