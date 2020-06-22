import React from "react";

import { data } from "@Mock/detailedIssue";
import CustomAvatar from "@Components/Common/CustomAvatar";

import calcTimeDiff from "@Utils/calcTimeDiff";

import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import { makeStyles } from "@material-ui/core/styles";

const ToolBar = ({ userName, createdAt }) => {
  const EDIT_BTN_TEXT = "Edit";

  const classes = useStyles();

  const statusMessage = `commented ${calcTimeDiff(createdAt)}`;

  return (
    <Box display="flex" justifyContent="space-between" width="100%">
      <Typography
        color="textSecondary"
        variant="subtitle1"
        component="div"
        className={classes.userName}
      >
        <strong>{userName}</strong>
        <span>{statusMessage}</span>
      </Typography>
      <Button>{EDIT_BTN_TEXT}</Button>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  userName: {
    lineHeight: "40px",
    "& strong": {
      fontWeight: "bold",
      marginRight: theme.spacing(1),
      color: theme.palette.text.primary,
    },
  },
}));

export default ToolBar;
