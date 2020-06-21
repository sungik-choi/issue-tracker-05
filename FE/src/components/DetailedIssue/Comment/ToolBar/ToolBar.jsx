import React from "react";

import { data } from "@Mock/detailedIssue";
import CustomAvatar from "@Components/Common/CustomAvatar";

import Box from "@material-ui/core/Box";
import { makeStyles } from "@material-ui/core/styles";

const ToolBar = () => {
  const {
    author: { userId, userName, avatarUrl },
    createdAt,
  } = data.issue;

  const classes = useStyles();

  return (
    <>
      <Box position="relative">
        sss
        <CustomAvatar id={userId} url={avatarUrl} className={classes.avatar} />
      </Box>
    </>
  );
};

const useStyles = makeStyles((theme) => ({
  avatar: {
    position: "absolute",
    top: 0,
    left: -45,
  },
}));

export default ToolBar;
