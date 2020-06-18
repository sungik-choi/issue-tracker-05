import React from "react";
import PropTypes from "prop-types";

import { makeStyles } from "@material-ui/core/styles";
import Button from "@material-ui/core/Button";
import Chip from "@material-ui/core/Chip";

const LinkButton = ({ text, icon, count, ...props }) => {
  const classes = useStyles();

  return (
    <>
      <Button startIcon={icon} {...props}>
        {text}
        {count && <Chip label={count} size="small" className={classes.count} />}
      </Button>
    </>
  );
};

const useStyles = makeStyles((theme) => ({
  count: {
    marginLeft: theme.spacing(0.5),
    pointerEvents: "none",
  },
}));

LinkButton.defaultProps = {
  icon: null,
  count: null,
};

LinkButton.propTypes = {
  text: PropTypes.string.isRequired,
  icon: PropTypes.oneOf([PropTypes.element, PropTypes.null]),
  count: PropTypes.oneOf([PropTypes.number, PropTypes.null]),
};

export default LinkButton;
