import React from "react";
import PropTypes from "prop-types";

import Box from "@material-ui/core/Box";

import { filterButtonList } from "@Mock/data";

import FilterButton from "./FilterButton";

const TableFilters = ({ bSelectedIssueExist }) => {
  const markAsFilterButton = {
    type: "Mark as",
    menuTitle: "Actions",
    menuList: [
      {
        text: "open",
        clickHandler: null,
      },
      {
        text: "close",
        clickHandler: null,
      },
    ],
  };

  return (
    <Box display="flex">
      {bSelectedIssueExist ? (
        <FilterButton
          type={markAsFilterButton.type}
          menuTitle={markAsFilterButton.menuTitle}
          menuList={markAsFilterButton.menuList}
        />
      ) : (
        filterButtonList.map(({ type, menuTitle, menuList }) => (
          <FilterButton key={type} type={type} menuTitle={menuTitle} menuList={menuList} />
        ))
      )}
    </Box>
  );
};

TableFilters.propTypes = {
  bSelectedIssueExist: PropTypes.bool.isRequired,
};

export default TableFilters;
