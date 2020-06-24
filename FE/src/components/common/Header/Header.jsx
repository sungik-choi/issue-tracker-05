import React, { useContext } from "react";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import CollectionsBookmarkIcon from "@material-ui/icons/CollectionsBookmark";

import { UserContext } from "@Contexts/userContext";

import UserMenu from "./UserMenu";

const TITLE_TEXT = "Issue Tracker";

const Header = () => {
  const classes = useStyles();

  const {
    user: { id, avatarUrl },
  } = useContext(UserContext);

  return (
    <div className={classes.root}>
      <AppBar position="fixed" className={classes.colorDefault}>
        <Toolbar>
          <Box mr={2}>
            <CollectionsBookmarkIcon />
          </Box>
          <Typography variant="h6" className={classes.title}>
            {TITLE_TEXT}
          </Typography>
          {id && <UserMenu userId={id} url={avatarUrl} />}
        </Toolbar>
      </AppBar>
    </div>
  );
};

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  title: {
    flexGrow: 1,
  },
  colorDefault: {
    backgroundColor: theme.palette.grey[900],
  },
}));

export default Header;
