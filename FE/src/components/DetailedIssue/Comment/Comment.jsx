import React, { useContext } from "react";

import { DetailedIssueContext } from "@Contexts/detailedIssueContext";
import { data } from "@Mock/detailedIssue";

import CustomTable from "@Components/common/CustomTable";
import CustomAvatar from "@Components/common/CustomAvatar";
import ToolBar from "./ToolBar";
import Write from "./Write/Write";
import Edit from "./Edit/Edit";
import editHandler from "@Components/DetailedIssue/editHandler";

import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";
import TextareaAutosize from "@material-ui/core/TextareaAutosize";
import { makeStyles } from "@material-ui/core/styles";

const Comment = () => {
  const {
    commentInfo: { comments },
    issue: {
      author: { name },
    },
  } = useContext(DetailedIssueContext).detailedIssue;

  const classes = useStyles();

  const tableRender = (userName, userId, description, createdAt) => {
    const {
      isEdit,
      titleValue,
      inputTitle,
      onToggle,
      onChangeInput,
      onClickSave,
      onClickClose,
    } = editHandler(description);

    const bodyContentRender = () => {
      if (isEdit) {
        return [
          {
            id: userId,
            contents: (
              <Edit value={titleValue} inputValue={inputTitle} onChangeInput={onChangeInput} />
            ),
          },
        ];
      } else {
        return [{ id: userId, contents: description }];
      }
    };

    return (
      <CustomTable
        ariaLabel={"Issue comment"}
        className={classes.table}
        hover={false}
        headContents={
          <ToolBar
            userName={userName}
            createdAt={createdAt}
            authorName={name}
            clickHandler={onToggle}
          />
        }
        bodyContents={bodyContentRender()}
      />
    );
  };

  return (
    <Box my={4} ml={"40px"} width="70%">
      {comments.map((comment) => {
        const {
          id,
          createdAt,
          description,
          commenter: { avatarUrl, name },
        } = comment;

        const commentTable = (
          <Box position="relative" mb={4} key={id}>
            <CustomAvatar id={name} url={avatarUrl} className={classes.avatar} tooltip />
            <Box>{tableRender(name, id, description, createdAt)}</Box>
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
    "& textarea": {
      width: "100%",
    },
  },
  edit: {},
  avatar: {
    position: "absolute",
    top: 3,
    left: -47,
  },
}));

export default Comment;
