import React from "react";
import PropTypes from "prop-types";

import Box from "@material-ui/core/Box";

import FilterButton from "./FilterButton";

const TableFilters = ({ bSelectedIssueExist }) => {
  const markAsFilterButton = "Mark as";
  const filterButtonList = ["Author", "Label", "Projects", "Milestones", "Assignees", "Sort"];

  return (
    <Box>
      {bSelectedIssueExist ? (
        <FilterButton text={markAsFilterButton} />
      ) : (
        filterButtonList.map((buttonText) => <FilterButton key={buttonText} text={buttonText} />)
      )}
    </Box>
  );
};

TableFilters.propTypes = {
  bSelectedIssueExist: PropTypes.bool.isRequired,
};

export default TableFilters;
