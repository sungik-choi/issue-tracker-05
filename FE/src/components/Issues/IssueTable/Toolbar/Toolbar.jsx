import React from "react";
import PropTypes from "prop-types";

import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import Checkbox from "@material-ui/core/Checkbox";

import TableFilters from "./TableFilters/TableFilters";

const Toolbar = ({
  selectedIssueSize,
  bAtLeastOneSelectedIssue,
  bAllSelectedIssue,
  clickHandler,
}) => {
  const SELECTED_TEXT = "selected";

  return (
    <>
      <Box display="flex" alignItems="center">
        <Checkbox
          color="primary"
          indeterminate={bAtLeastOneSelectedIssue}
          checked={bAllSelectedIssue}
          onChange={clickHandler}
        />
        {!!selectedIssueSize && (
          <Typography>
            {selectedIssueSize} {SELECTED_TEXT}
          </Typography>
        )}
      </Box>
      <TableFilters bSelectedIssueExist={!!selectedIssueSize} />
    </>
  );
};

Toolbar.propTypes = {
  selectedIssueSize: PropTypes.number.isRequired,
  bAtLeastOneSelectedIssue: PropTypes.bool.isRequired,
  bAllSelectedIssue: PropTypes.bool.isRequired,
  clickHandler: PropTypes.func.isRequired,
};

export default Toolbar;
