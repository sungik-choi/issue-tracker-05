import React from "react";

import TextareaAutosize from "@material-ui/core/TextareaAutosize";
import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import ButtonGroup from "@material-ui/core/ButtonGroup";
import { makeStyles } from "@material-ui/core/styles";

const COMMENT_BTN_TEXT = "comment ";
const CANCEL_BTN_TEXT = "Cancel";

const Edit = () => {
  const classes = useStyles();

  return (
    <Box className={classes.root}>
      <TextareaAutosize aria-label="Comment write" rowsMin={3} placeholder="Leave a comment" />
      <ButtonGroup aria-label="outlined primary button group">
        <Button variant="contained" color="primary">
          {COMMENT_BTN_TEXT}
        </Button>
        <Button variant="contained">{CANCEL_BTN_TEXT}</Button>
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

export default Edit;
