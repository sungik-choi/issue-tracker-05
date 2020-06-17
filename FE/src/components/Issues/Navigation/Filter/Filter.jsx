import React from "react";

import Box from "@material-ui/core/Box";
import Menu from "./Menu";
import SearchBar from "./SearchBar";

const Filter = () => {
  return (
    <Box display="flex">
      <Menu />
      <SearchBar />
    </Box>
  );
};

export default Filter;
