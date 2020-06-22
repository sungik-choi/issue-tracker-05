import React from "react";

import Title from "./Title/Title";
import IssueStatus from "./IssueStatus/IssueStatus";

import Box from "@material-ui/core/Box";

const Header = () => {
  return (
    <Box my={4}>
      <Title />
      <IssueStatus />
    </Box>
  );
};

export default Header;
