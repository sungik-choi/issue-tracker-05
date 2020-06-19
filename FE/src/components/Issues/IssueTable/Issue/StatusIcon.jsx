import React from "react";
import PropTypes from "prop-types";

import ErrorOutlineIcon from "@material-ui/icons/ErrorOutline";
import CheckCircleOutlineIcon from "@material-ui/icons/CheckCircleOutline";

const StatusIcon = ({ isOpened }) => {
  return (
    <>
      {isOpened ? (
        <ErrorOutlineIcon color="primary" />
      ) : (
        <CheckCircleOutlineIcon color="secondary" />
      )}
    </>
  );
};

StatusIcon.defaultProps = {
  isOpened: true,
};

StatusIcon.propTypes = {
  isOpened: PropTypes.bool,
};

export default StatusIcon;
