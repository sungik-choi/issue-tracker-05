import React from "react";
import PropTypes from "prop-types";

import ErrorOutlineIcon from "@material-ui/icons/ErrorOutline";
import CheckCircleOutlineIcon from "@material-ui/icons/CheckCircleOutline";

const StatusIcon = ({ closed, color }) => {
  return (
    <>
      {closed ? (
        <CheckCircleOutlineIcon color={color.closed} />
      ) : (
        <ErrorOutlineIcon color={color.opened} />
      )}
    </>
  );
};

StatusIcon.defaultProps = {
  closed: false,
  color: { closed: "default", opened: "default" },
};

StatusIcon.propTypes = {
  closed: PropTypes.bool,
  color: PropTypes.objectOf(PropTypes.string),
};

export default StatusIcon;
