import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import Button from "@material-ui/core/Button";

const NewIssueButton = () => {
  const NEW_ISSUE_BTN_TEXT = "New issue";
  return (
    <Button variant="contained" color="primary" disableElevation>
      {NEW_ISSUE_BTN_TEXT}
    </Button>
  );
};

export default NewIssueButton;
