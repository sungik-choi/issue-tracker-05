import React from "react";

import Box from "@material-ui/core/Box";

import Title from "./Title/Title";
import IssueStatus from "./IssueStatus/IssueStatus";

const Header = () => {
  return (
    <Box my={4}>
      <Title />
      <IssueStatus />
    </Box>
  );
};

export default Header;
