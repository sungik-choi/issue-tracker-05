import React, { useContext } from "react";
import { Link } from "react-router-dom";

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
    user: { name, avatarUrl },
  } = useContext(UserContext);

  return (
    <div className={classes.root}>
      <AppBar position="fixed" className={classes.colorDefault}>
        <Toolbar className={classes.toolbar}>
          <Box className={classes.title} component={Link} to="/" display="flex" alignItems="center">
            <Box mr={2}>
              <CollectionsBookmarkIcon />
            </Box>
            <Typography variant="h6">{TITLE_TEXT}</Typography>
          </Box>
          {name && <UserMenu userId={name} url={avatarUrl} />}
        </Toolbar>
      </AppBar>
    </div>
  );
};

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  toolbar: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
  },
  title: {
    color: theme.palette.common.white,
    textDecoration: "none",
  },
  colorDefault: {
    backgroundColor: theme.palette.grey[900],
  },
}));

export default Header;
