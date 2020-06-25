import React, { useContext } from "react";

import { DetailedIssueContext } from "@Contexts/detailedIssueContext";
import { editCommentFetchOptions } from "@Reducers/detailedIssueReducer";

import TextareaAutosize from "@material-ui/core/TextareaAutosize";
import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import ButtonGroup from "@material-ui/core/ButtonGroup";
import { makeStyles } from "@material-ui/core/styles";

import pipe from "@Utils/pipe";
import useFetch from "@Hooks/useFetch";

const COMMENT_BTN_TEXT = "comment ";
const CANCEL_BTN_TEXT = "Cancel";

const Edit = ({ id, userId, value, onChange, onClickClose, onClickSave }) => {
  const classes = useStyles();
  const { detailedIssueDispatch } = useContext(DetailedIssueContext);

  const { getData } = pipe(
    editCommentFetchOptions,
    useFetch,
  )({ detailedIssueDispatch, id, userId, value });

  console.log(value);

  const onSubmitForm = (e) => {
    e.preventDefault();
    console.log(getData, 2);
    onClickSave(getData);
  };

  return (
    <form onSubmit={onSubmitForm} className={classes.root}>
      <TextareaAutosize
        aria-label="Comment write"
        rowsMin={3}
        placeholder="Leave a comment"
        value={value}
        onChange={onChange}
      />
      <ButtonGroup aria-label="outlined primary button group">
        <Button variant="contained" color="primary" type="submit" value="submit">
          {COMMENT_BTN_TEXT}
        </Button>
        <Button variant="contained" onClick={onClickClose}>
          {CANCEL_BTN_TEXT}
        </Button>
      </ButtonGroup>
    </form>
  );
};

const useStyles = makeStyles(() => ({
  root: {
    width: "100%",
    "& textarea": {
      width: "100%",
    },
  },
}));

export default Edit;
