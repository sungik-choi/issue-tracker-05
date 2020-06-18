import React from "react";
import PropTypes from "prop-types";

import { makeStyles } from "@material-ui/core/styles";
import Chip from "@material-ui/core/Chip";

const Label = ({ name, size, backgroundColor, color }) => {
  const props = { backgroundColor, color };
  const classes = useStyles(props);

  return (
    <Chip
      label={name}
      size={size}
      classes={{
        root: classes.root,
      }}
    />
  );
};

const useStyles = makeStyles({
  root: ({ backgroundColor, color }) => ({
    backgroundColor,
    color,
    pointerEvents: "none",
  }),
});

Label.defaultProps = {
  size: "small",
};

Label.propTypes = {
  name: PropTypes.string.isRequired,
  size: PropTypes.oneOf(["small", "medium"]),
  backgroundColor: PropTypes.string.isRequired,
  color: PropTypes.string.isRequired,
};

export default Label;
