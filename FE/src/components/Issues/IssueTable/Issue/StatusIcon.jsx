import React from "react";
import PropTypes from "prop-types";

import ErrorOutlineIcon from "@material-ui/icons/ErrorOutline";
import CheckCircleOutlineIcon from "@material-ui/icons/CheckCircleOutline";

const StatusIcon = ({ closed }) => {
  return (
    <>
      {closed ? <CheckCircleOutlineIcon color="secondary" /> : <ErrorOutlineIcon color="primary" />}
    </>
  );
};

StatusIcon.defaultProps = {
  closed: false,
};

StatusIcon.propTypes = {
  closed: PropTypes.bool,
};

export default StatusIcon;
