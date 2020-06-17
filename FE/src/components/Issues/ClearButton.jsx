import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import CancelPresentationIcon from "@material-ui/icons/CancelPresentation";

const ClearButton = () => {
  if (null) return null; // 조건문에 상태값 넣기

  const CLEAR_BTN_TEXT = "Clear current search query, filters, and sorts";
  const classes = useStyles();

  return (
    <Box component="div" mb={2} className={classes.root}>
      <Button disableTouchRipple={true}>
        <span className={classes.icon}>
          <CancelPresentationIcon />
        </span>
        <span>{CLEAR_BTN_TEXT}</span>
      </Button>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  root: {
    "& button": {
      textTransform: "none",
      fontWeight: "bold",
      color: theme.palette.grey[600],
      fontSize: 17,
      "&:hover": {
        background: "none",
        color: theme.palette.info.dark,
      },
      "& span": {
        paddingRight: 8,
      },
    },
  },
  icon: {
    height: 23,
  },
}));

export default ClearButton;
