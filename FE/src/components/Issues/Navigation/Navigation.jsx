import React from "react";

import Filter from "./Filter/Filter";
import LinkButtons from "./LinkButtons/LinkButton";

import Box from "@material-ui/core/Box";

const Navigation = () => {
  return (
    <Box component="nav" mt={6} mb={5} display="flex">
      <Filter />
      <LinkButtons />
    </Box>
  );
};

export default Navigation;
