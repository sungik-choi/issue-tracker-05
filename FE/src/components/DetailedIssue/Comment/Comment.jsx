import React from "react";

import { data } from "@Mock/detailedIssue";

import CustomTable from "@Components/common/CustomTable";
import CustomAvatar from "@Components/common/CustomAvatar";
import ToolBar from "./ToolBar";
import Write from "./Write/Write";

import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";
import TextareaAutosize from "@material-ui/core/TextareaAutosize";
import { makeStyles } from "@material-ui/core/styles";

const Comment = () => {
  const authorName = data.issue.author.userName;
  const { comments } = data.issue.commentInfo;

  const classes = useStyles();

  const tableRender = (userName, userId, description, createdAt) => {
    return (
      <CustomTable
        ariaLabel={"Issue comment"}
        className={classes.table}
        hover={false}
        headContents={<ToolBar userName={userName} createdAt={createdAt} authorName={authorName} />}
        bodyContents={[{ id: userId, contents: description }]}
        bodyContents={[
          {
            id: userId,
            contents: <TextareaAutosize aria-label="Comment edit" rowsMin={3} />,
          },
        ]}
      />
    );
  };

  return (
    <Box my={4} ml={"40px"} width="70%">
      {comments.map((comment) => {
        const { userId, userName, avatarUrl, createdAt, description, author } = comment;

        const commentTable = (
          <Box position="relative" mb={4} key={userId}>
            <CustomAvatar id={userName} url={avatarUrl} className={classes.avatar} tooltip />
            <Box>{tableRender(userName, userId, description, createdAt, author)}</Box>
            {/* <Box ml="40px" width="70%">
              {tableRender(userName, userId, description, createdAt, author)}
            </Box> */}
          </Box>
        );

        return commentTable;
      })}
      <Write />
    </Box>
  );
};

const useStyles = makeStyles(() => ({
  table: {
    marginBottom: 40,
    "& th": {
      padding: "3px 20px",
    },
    "& .MuiTableRow-hover": {
      pointerEvents: "none",
    },
  },
  edit: {
    "& textarea": {
      width: "100%",
    },
  },
  avatar: {
    position: "absolute",
    top: 3,
    left: -47,
  },
}));

export default Comment;
