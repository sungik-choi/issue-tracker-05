import React from "react";

import calcTimeDiff from "@Utils/calcTimeDiff";

import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import Chip from "@material-ui/core/Chip";
import { makeStyles } from "@material-ui/core/styles";

const ToolBar = ({ userName, createdAt, authorName, clickHandler }) => {
  const EDIT_BTN_TEXT = "Edit";

  const classes = useStyles();

  const statusMessage = `commented ${calcTimeDiff(createdAt)}`;

  return (
    <Box display="flex" alignItems="center" justifyContent="space-between" width="100%">
      <Typography
        color="textSecondary"
        variant="subtitle1"
        component="div"
        className={classes.userName}
      >
        <strong>{userName}</strong>
        <span>{statusMessage}</span>
      </Typography>
      {userName === authorName && (
        <div>
          <Chip label="Author" variant="outlined" />
          <Button onClick={clickHandler}>{EDIT_BTN_TEXT}</Button>
        </div>
      )}
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  userName: {
    lineHeight: "40px",
    "& strong": {
      fontWeight: "bold",
      marginRight: theme.spacing(1),
      color: theme.palette.text.primary,
    },
  },
}));

export default ToolBar;
