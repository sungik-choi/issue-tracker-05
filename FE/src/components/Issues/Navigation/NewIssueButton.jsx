import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import Button from "@material-ui/core/Button";
import grey from "@material-ui/core/colors/grey";

const NewIssueButton = () => {
  const NEW_ISSUE_BTN_TEXT = "New issue";
  const classes = useStyles();

  return (
    <Button variant="contained" disableElevation className={classes.button}>
      {NEW_ISSUE_BTN_TEXT}
    </Button>
  );
};

const useStyles = makeStyles((theme) => ({
  button: {
    border: `1px solid${grey[600]}`,
    textTransform: "none",
    backgroundColor: theme.palette.success.main,
    color: theme.palette.common.white,
    "&:hover": {
      backgroundColor: theme.palette.success.dark,
    },
  },
}));

export default NewIssueButton;
