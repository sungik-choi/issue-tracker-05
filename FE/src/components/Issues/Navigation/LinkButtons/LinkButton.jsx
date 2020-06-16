import React from "react";

import Button from "@material-ui/core/Button";
import { makeStyles } from "@material-ui/core/styles";
import grey from "@material-ui/core/colors/grey";

const LinkButton = ({ text, count }) => {
  const classes = useStyles();

  return (
    <Button variant="outlined" className={classes.root}>
      <span>{text}</span>
      <span className={classes.count}>{count}</span>
    </Button>
  );
};

const useStyles = makeStyles(() => ({
  root: {
    textTransform: "none",
    "& span": {
      fontWeight: "bold",
      fontSize: 13,
      color: grey[700],
    },
  },

  count: {
    borderRadius: "50%",
    marginLeft: 5,
    display: "inline-block",
    padding: "0 8px",
    backgroundColor: grey[300],
  },
}));

export default LinkButton;
