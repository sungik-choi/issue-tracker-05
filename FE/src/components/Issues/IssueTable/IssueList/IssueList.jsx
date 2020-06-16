import React from "react";

import Box from "@material-ui/core/Box";
import Checkbox from "@material-ui/core/Checkbox";

import { userList } from "@Mock/data";
import Contents from "./Contents/Contents";
import StatusIcon from "./StatusIcon";
import AvatarStack from "./AvatarStack";

const IssueList = ({ id, isSelected, clickHandler }) => {
  return (
    <>
      <Box display="flex" alignItems="center">
        <Checkbox color="primary" checked={isSelected(id)} onClick={() => clickHandler(id)} />
        <StatusIcon />
        <Contents />
      </Box>
      <AvatarStack userData={userList} />
    </>
  );
};

export default IssueList;
