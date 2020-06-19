import React from "react";
import PropTypes from "prop-types";

import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";

import calcTimeDiff from "@Utils/calcTimeDiff";

const Details = ({ id, time, author }) => {
  const text = `#${id} opened ${calcTimeDiff(time)} ago by ${author}`;

  return (
    <Box color="text.secondary">
      <Typography variant="body2">{text}</Typography>
    </Box>
  );
};

Details.propTypes = {
  id: PropTypes.number.isRequired,
  time: PropTypes.string.isRequired,
  author: PropTypes.string.isRequired,
};

export default Details;
