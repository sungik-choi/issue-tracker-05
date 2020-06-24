import React from "react";
import PropTypes from "prop-types";

import Box from "@material-ui/core/Box";
import CircularProgress from "@material-ui/core/CircularProgress";

const LoadingIndicator = ({ size }) => {
  return (
    <Box height="100vh" display="flex" justifyContent="center" alignItems="center">
      <CircularProgress size={size} />
    </Box>
  );
};

LoadingIndicator.defaultProps = {
  size: 60,
};

LoadingIndicator.propTypes = {
  size: PropTypes.oneOfType([PropTypes.string, PropTypes.number]),
};

export default LoadingIndicator;
