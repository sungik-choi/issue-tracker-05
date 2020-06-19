import React from "react";
import PropTypes from "prop-types";

import Box from "@material-ui/core/Box";
import Checkbox from "@material-ui/core/Checkbox";

import Contents from "./Contents/Contents";
import StatusIcon from "./StatusIcon";
import AvatarStack from "./AvatarStack";

const Issue = ({
  id,
  title,
  milestone,
  attachedLabels,
  createdAt,
  author,
  allocatedAssignees,
  isOpened,
  isSelectedIssue,
  clickHandler,
}) => {
  return (
    <>
      <Box display="flex" alignItems="center">
        <Checkbox color="primary" checked={null} onChange={null} />
        <StatusIcon isOpened={isOpened} />
        <Contents
          id={id}
          title={title}
          attachedLabels={attachedLabels}
          createdAt={createdAt}
          author={author}
        />
      </Box>
      <AvatarStack allocatedAssignees={allocatedAssignees} />
    </>
  );
};

Issue.propTypes = {
  id: PropTypes.number.isRequired,
  isSelectedIssue: PropTypes.func.isRequired,
  clickHandler: PropTypes.func.isRequired,
};

export default Issue;
