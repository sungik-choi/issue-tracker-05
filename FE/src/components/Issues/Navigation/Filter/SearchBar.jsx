import React from "react";

import { fade, makeStyles } from "@material-ui/core/styles";

import InputBase from "@material-ui/core/InputBase";
import SearchIcon from "@material-ui/icons/Search";
import grey from "@material-ui/core/colors/grey";

const SEARCH_PLACEHOLDER = "Search all issues";

const SearchBar = () => {
  const classes = useStyles();

  return (
    <form className={classes.search} aria-label="Issues">
      <div className={classes.searchIcon}>
        <SearchIcon />
      </div>
      <InputBase
        placeholder={SEARCH_PLACEHOLDER}
        classes={{
          root: classes.inputRoot,
          input: classes.inputInput,
        }}
        inputProps={{ "aria-label": "Search all issues" }}
      />
    </form>
  );
};

const useStyles = makeStyles((theme) => ({
  search: {
    height: 32.5,
    position: "relative",
    borderRadius: "0 5px 5px 0",
    border: "1px solid" + grey[400],
    borderLeft: "none",
    backgroundColor: grey[50],
    "&:hover": {
      backgroundColor: fade(grey[300], 0.25),
    },
    width: "100%",
  },
  searchIcon: {
    padding: theme.spacing(0, 2),
    color: grey[400],
    height: "100%",
    position: "absolute",
    pointerEvents: "none",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
  },
  inputRoot: {
    color: "inherit",
  },
  inputInput: {
    padding: theme.spacing(1, 1, 1, 0),
    color: grey[700],
    paddingLeft: `calc(1em + ${theme.spacing(4)}px)`,
    transition: theme.transitions.create("width"),
    height: "100%",
    [theme.breakpoints.up("md")]: {
      width: "550px",
    },
  },
}));

export default SearchBar;
