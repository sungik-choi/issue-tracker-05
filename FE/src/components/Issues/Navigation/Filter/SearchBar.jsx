import React from "react";

import { fade, makeStyles } from "@material-ui/core/styles";

import Box from "@material-ui/core/Box";
import InputBase from "@material-ui/core/InputBase";
import SearchIcon from "@material-ui/icons/Search";

const SearchBar = () => {
  const SEARCH_PLACEHOLDER = "Search all issues";
  const classes = useStyles();

  return (
    <Box display="flex" alignItems="center" className={classes.search}>
      <div className={classes.searchIcon}>
        <SearchIcon />
      </div>
      <InputBase
        placeholder={SEARCH_PLACEHOLDER}
        classes={{
          root: classes.inputRoot,
          input: classes.inputInput,
        }}
        inputProps={{ "aria-label": "search" }}
      />
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  search: {
    borderRadius: "0 5px 5px 0",
    border: `1px solid ${theme.palette.grey[400]}`,
    borderLeft: "none",
  },
  searchIcon: {
    padding: theme.spacing(0, 1),
    color: theme.palette.grey[400],
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
    color: theme.palette.grey[800],
    paddingLeft: `calc(1rem + ${theme.spacing(3)}px)`,
    transition: theme.transitions.create("width"),
    height: "100%",
    [theme.breakpoints.up("md")]: {
      width: "550px",
    },
  },
}));

export default SearchBar;
