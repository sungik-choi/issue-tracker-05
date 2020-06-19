import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import AppBar from "@material-ui/core/AppBar";

import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import CollectionsBookmarkIcon from "@material-ui/icons/CollectionsBookmark";

import UserMenu from "./UserMenu";

const Header = () => {
  const classes = useStyles();
  const TITLE_TEXT = "Issue Tracker";

  // ! 현재 로그인한 유저의 정보를 CustomAvatar에 id 와 url 담을 것
  // ! 정보가 없다면 유저 아이콘 보여주지 않음
  // ? Context API 사용하면 될 거 같다

  return (
    <div className={classes.root}>
      <AppBar position="static" className={classes.colorDefault}>
        <Toolbar>
          <Box mr={2}>
            <CollectionsBookmarkIcon />
          </Box>
          <Typography variant="h6" className={classes.title}>
            {TITLE_TEXT}
          </Typography>
          <UserMenu />
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
