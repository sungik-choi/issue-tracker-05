import React from "react";

import { data } from "@Mock/detailedIssue";
import CustomAvatar from "@Components/Common/CustomAvatar";

import calcTimeDiff from "@Utils/calcTimeDiff";

import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import { makeStyles } from "@material-ui/core/styles";

const ToolBar = () => {
  const {
    author: { userId, userName, avatarUrl },
    createdAt,
  } = data.issue;

  const classes = useStyles();

  const statusMessage = `commented ${calcTimeDiff(createdAt)}`;

  return (
    <Box position="relative" pl={3} display="flex" justifyContent="space-between" px={2}>
      <CustomAvatar id={userId} url={avatarUrl} className={classes.avatar} />
      <Typography
        color="textSecondary"
        variant="subtitle1"
        component="div"
        className={classes.userName}
      >
        <strong>{userName}</strong>
        <span>{statusMessage}</span>
      </Typography>
      <Button>Edit</Button>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  avatar: {
    position: "absolute",
    top: 0,
    left: -45,
  },
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
