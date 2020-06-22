import React from "react";
import PropTypes from "prop-types";

import Box from "@material-ui/core/Box";
import Checkbox from "@material-ui/core/Checkbox";

import { assigneeType } from "@Types/issueType";

import Contents from "./Contents/Contents";
import StatusIcon from "./StatusIcon";
import AvatarStack from "./AvatarStack";

const Issue = ({
  id,
  isSelectedIssue,
  clickHandler,
  data: { allocatedAssignees, isOpened, ...contentsData },
}) => {
  return (
    <>
      <Box display="flex" alignItems="center">
        <Checkbox color="primary" checked={isSelectedIssue} onChange={clickHandler} />
        <StatusIcon isOpened={isOpened} />
        <Contents id={id} data={contentsData} />
      </Box>
      <AvatarStack allocatedAssignees={allocatedAssignees} />
    </>
  );
};

Issue.propTypes = {
  id: PropTypes.number.isRequired,
  isSelectedIssue: PropTypes.bool.isRequired,
  clickHandler: PropTypes.func.isRequired,
  data: PropTypes.shape({
    allocatedAssignees: assigneeType.isRequired,
    isOpened: PropTypes.bool.isRequired,
  }).isRequired,
};

export default Issue;
