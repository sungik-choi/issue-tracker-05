import React from "react";

import { data } from "@Mock/detailedIssue";

import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";

const TitleBox = ({ id, title, onClickEdit }) => {
  const Edit_BTN = "edit";

  const classes = useStyles();

  return (
    <Box display="flex" alignItems="center" justifyContent="space-between">
      <Typography variant="h3" component="h2">
        <span>{title}</span>
        <span className={classes.issueNum}>#{id}</span>
      </Typography>
      <Button variant="contained" onClick={onClickEdit}>
        {Edit_BTN}
      </Button>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  issueNum: {
    color: theme.palette.text.secondary,
    marginLeft: theme.spacing(2),
  },
}));

export default TitleBox;
