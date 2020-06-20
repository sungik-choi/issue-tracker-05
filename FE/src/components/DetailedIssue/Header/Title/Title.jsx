import React, { useState } from "react";

import { data } from "@Mock/detailedIssue";
import InputBox from "./InputBox";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";

const Title = () => {
  const classes = useStyles();

  const EIDT_BTN_TEXT = "Edit";

  const title = data.issue.issueTitle;
  const id = data.issue.issueId;

  const [isEdit, setIsEdit] = useState(false);

  const onClickEdit = () => {
    setIsEdit((prevState) => !prevState);
  };

  return (
    <Box display="flex" alignItems="center" justifyContent="space-between">
      {isEdit ? (
        <InputBox />
      ) : (
        <Typography variant="h3" component="h2" gutterBottom>
          <span>{title}</span>
          <span className={classes.issueNum}>#{id}</span>
        </Typography>
      )}
      <Button variant="contained" onClick={onClickEdit}>
        {EIDT_BTN_TEXT}
      </Button>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  issueNum: {
    color: theme.palette.text.secondary,
    marginLeft: theme.spacing(1),
  },
}));

export default Title;
