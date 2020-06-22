import React from "react";

import { data } from "@Mock/detailedIssue";

import Table from "./Table";
import CustomTable from "@Components/common/CustomTable";
import ToolBar from "./ToolBar/ToolBar";

import { makeStyles } from "@material-ui/core/styles";

const Comment = () => {
  const comments = data.issue.commentInfo.comments;

  const contents = [{ id: userId, contents: description }];
  const classes = useStyles();

  return (
    <>
      <Table userId={userId} avatarUrl={avatarUrl}>
        {comments.map((comment) => {
          <CustomTable
            headContents={<ToolBar userName={comment.userName} createdAt={comment.createdAt} />}
            bodyContents={[{ id: comment.userId, contents: comment.description }]}
            className={classes.table}
          />;
        })}
      </Table>
    </>
  );
};

const useStyles = makeStyles(() => ({
  table: {
    "& th": {
      padding: "3px 20px",
    },
    "& .MuiTableRow-hover": {
      pointerEvents: "none",
    },
  },
}));

export default Comment;
