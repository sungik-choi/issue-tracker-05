import React from "react";

import Button from "@material-ui/core/Button";
import { makeStyles } from "@material-ui/core/styles";
import grey from "@material-ui/core/colors/grey";

const LinkButton = () => {
  const classes = useStyles();

  return (
    <div>
      <Button variant="outlined">
        <span>Default</span>
        <span className={classes.count}>2</span>
      </Button>
    </div>
  );
};

const useStyles = makeStyles((theme) => ({
  count: {
    borderRadius: "50%",
    marginLeft: 5,
    display: "inline-block",
    padding: "0 8px",
    backgroundColor: grey[300],
  },
}));

export default LinkButton;
