import React from "react";

import Filter from "./Filter/Filter";

import Box from "@material-ui/core/Box";

const Navigation = () => {
  return (
    <Box component="nav" mt={6} mb={5}>
      <Filter />
    </Box>
  );
};

export default Navigation;
