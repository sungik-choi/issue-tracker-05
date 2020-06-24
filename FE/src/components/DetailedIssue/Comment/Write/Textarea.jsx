import React from "react";

import editHandler from "@Components/DetailedIssue/editHandler";

import TextareaAutosize from "@material-ui/core/TextareaAutosize";
import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import ButtonGroup from "@material-ui/core/ButtonGroup";
import { makeStyles } from "@material-ui/core/styles";

const COMMENT_BTN_TEXT = "comment";
const CANCEL_BTN_TEXT = "close issue";
const REOPEN_BTN_TEXT = "reopen issue";

const TextArea = () => {
  const classes = useStyles();

  const { isEdit, onToggle, onClickSave, onClickClose } = editHandler();

  return (
    <Box className={classes.root}>
      <TextareaAutosize aria-label="Comment write" rowsMin={3} placeholder="Leave a comment" />
      <ButtonGroup aria-label="outlined primary button group">
        <Button variant="contained" color="primary">
          {COMMENT_BTN_TEXT}
        </Button>
        {isEdit ? (
          <Button variant="contained" onClick={onToggle}>
            {CANCEL_BTN_TEXT}
          </Button>
        ) : (
          <Button variant="contained" onClick={onToggle}>
            {REOPEN_BTN_TEXT}
          </Button>
        )}
      </ButtonGroup>
    </Box>
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

export default TextArea;
