import React from "react";

import { data } from "@Mock/detailedIssue";

import Table from "./Table";
import CustomTable from "@Components/common/CustomTable";
import ToolBar from "./ToolBar/ToolBar";
import CustomAvatar from "@Components/Common/CustomAvatar";

import Box from "@material-ui/core/Box";
import { makeStyles } from "@material-ui/core/styles";

const Comment = () => {
  const { comments } = data.issue.commentInfo;

  const classes = useStyles();

  return (
    <>
      {comments.map((comment) => {
        const table = (
          <Box position="relative" mb={4} key={comment.userId + 1}>
            <CustomAvatar
              id={comment.userName}
              url={comment.avatarUrl}
              className={classes.avatar}
              tooltip
              key={comment.userId + 2}
            />
            <Box ml={"40px"} width="70%" key={comment.userId + 3}>
              <CustomTable
                headContents={<ToolBar userName={comment.userName} createdAt={comment.createdAt} />}
                bodyContents={[{ id: comment.userId, contents: comment.description }]}
                className={classes.table}
                key={comment.userId + 4}
              />
            </Box>
          </Box>
        );
        return table;
      })}
    </>
  );
};

const useStyles = makeStyles(() => ({
  table: {
    marginBottom: 35,
    "& th": {
      padding: "3px 20px",
    },
    "& .MuiTableRow-hover": {
      pointerEvents: "none",
    },
  },
  avatar: {
    position: "absolute",
    top: 3,
    left: -5,
  },
}));

export default Comment;
