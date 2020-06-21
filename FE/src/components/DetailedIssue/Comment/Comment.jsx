import React from "react";

import CustomTable from "@Components/common/CustomTable";
import ToolBar from "./ToolBar/ToolBar";
import { data } from "@Mock/detailedIssue";

import Box from "@material-ui/core/Box";
import CustomAvatar from "@Components/Common/CustomAvatar";
import { makeStyles } from "@material-ui/core/styles";

const Comment = () => {
  const { userId, description, avatarUrl } = data.issue.author;

  const contents = [{ id: userId, contents: description }];

  const classes = useStyles();

  return (
    <>
      <Box position="relative" mb={4}>
        <CustomAvatar id={userId} url={avatarUrl} className={classes.avatar} />
        <Box ml={"40px"} width="70%">
          <CustomTable
            headContents={<ToolBar />}
            bodyContents={contents}
            className={classes.table}
          />
        </Box>
      </Box>

      <Box position="relative">
        <CustomAvatar id={userId} url={avatarUrl} className={classes.avatar} />
        <Box ml={"40px"} width="70%">
          <CustomTable
            headContents={<ToolBar />}
            bodyContents={contents}
            className={classes.table}
          />
        </Box>
      </Box>
    </>
  );
};

const useStyles = makeStyles(() => ({
  avatar: {
    position: "absolute",
    top: 12,
    left: -4,
  },
  table: {
    "& th": {
      padding: "7px 20px",
    },
    "& .MuiTableRow-hover": {
      pointerEvents: "none",
    },
  },
}));

export default Comment;
