import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import CollectionsBookmarkIcon from "@material-ui/icons/CollectionsBookmark";

const Header = () => {
  const classes = useStyles();
  const TITLE_TEXT = "Issue Tracker";

  return (
    <AppBar position="static" className={classes.colorDefault}>
      <Toolbar>
        <Box mr={2}>
          <CollectionsBookmarkIcon />
        </Box>
        <Typography variant="h6">{TITLE_TEXT}</Typography>
      </Toolbar>
    </AppBar>
  );
};

const useStyles = makeStyles((theme) => ({
  colorDefault: {
    backgroundColor: theme.palette.grey[900],
  },
}));

export default Header;
