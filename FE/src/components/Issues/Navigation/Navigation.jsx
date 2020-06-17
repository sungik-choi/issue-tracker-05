import React from "react";

import Box from "@material-ui/core/Box";
import Filter from "./Filter/Filter";
import LinkButtons from "./LinkButtons/LinkButtons";
import NewIssueButton from "./NewIssueButton";

const Navigation = () => {
  return (
    <Box component="nav" mt={6} mb={5} maxHeight={38} display="flex" justifyContent="space-between">
      <Filter />
      <LinkButtons />
      <NewIssueButton />
    </Box>
  );
};

export default Navigation;
