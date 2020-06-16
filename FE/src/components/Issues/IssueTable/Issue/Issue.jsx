import React from "react";
import PropTypes from "prop-types";

import Box from "@material-ui/core/Box";
import Checkbox from "@material-ui/core/Checkbox";

import { userList } from "@Mock/data";
import Contents from "./Contents/Contents";
import StatusIcon from "./StatusIcon";
import AvatarStack from "./AvatarStack";

const Issue = ({ id, isSelectedIssue, clickHandler }) => {
  return (
    <>
      <Box display="flex" alignItems="center">
        <Checkbox color="primary" checked={isSelectedIssue(id)} onChange={() => clickHandler(id)} />
        <StatusIcon />
        <Contents />
      </Box>
      <AvatarStack userData={userList} />
    </>
  );
};

Issue.propTypes = {
  id: PropTypes.number.isRequired,
  isSelectedIssue: PropTypes.func.isRequired,
  clickHandler: PropTypes.func.isRequired,
};

export default Issue;
