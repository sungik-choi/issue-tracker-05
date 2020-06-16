import React from "react";

import Menu from "./Menu";
import SearchBar from "./SearchBar";

import Box from "@material-ui/core/Box";

const Filter = () => {
  return (
    <Box display="flex">
      <Menu />
      <SearchBar />
    </Box>
  );
};

export default Filter;
