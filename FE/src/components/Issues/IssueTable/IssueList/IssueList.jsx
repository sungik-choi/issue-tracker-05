import React from "react";

import Box from "@material-ui/core/Box";
import Checkbox from "@material-ui/core/Checkbox";

import Contents from "./Contents/Contents";
import StatusIcon from "./StatusIcon";
import AvatarStack from "./AvatarStack";

const IssueList = () => {
  return (
    <>
      <Box display="flex" alignItems="center">
        <Checkbox color="primary" />
        <StatusIcon />
        <Contents />
      </Box>
      <AvatarStack />
    </>
  );
};

export default IssueList;
