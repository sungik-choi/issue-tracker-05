import React from "react";

import { data } from "@Mock/detailedIssue";

import { makeStyles } from "@material-ui/core/styles";
import Typography from "@material-ui/core/Typography";
import Box from "@material-ui/core/Box";

const Title = () => {
  const classes = useStyles();

  const title = data.issue.issueTitle;
  const id = data.issue.issueId;

  return (
    <Typography variant="h3" component="h2" gutterBottom>
      <span>{title}</span>
      <span className={classes.issueNum}>#{id}</span>
    </Typography>
  );
};

const useStyles = makeStyles((theme) => ({
  issueNum: {
    color: theme.palette.text.secondary,
    marginLeft: theme.spacing(1),
  },
}));

export default Title;
