import React from "react";
import PropTypes from "prop-types";

import Box from "@material-ui/core/Box";

import FilterButton from "./FilterButton";

const TableFilters = ({ bSelectedIssueExist }) => {
  const FILTER_BY_TEXT = "Filter by";
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
  const filterButtonList = [
    {
      type: "Author",
      menuTitle: `${FILTER_BY_TEXT} Author`,
      menuList: [
        {
          text: "Unlabeled",
          clickHandler: null,
        },
        {
          text: "Pororo123",
          avatar: {
            id: "pororo",
            url:
              "https://lh3.googleusercontent.com/lv3q0LxixvhfsBwhLKzpp53EPMQO92jq98uOKqT9sL0hv4gF8l9bl6SRN23FLxkeJH3ldxZt-PreP1zddg",
          },
          name: "roro po",
          clickHandler: null,
        },
        {
          text: "ETC",
          clickHandler: null,
        },
      ],
    },
    {
      type: "Label",
      menuTitle: `${FILTER_BY_TEXT} Label`,
      menuList: [
        {
          text: "Unlabeled",
          clickHandler: null,
        },
        {
          text: "ETC",
          clickHandler: null,
        },
        {
          text: "something is wrong",
          label: {
            name: "BUG",
            backgroundColor: "#000",
            color: "#FFF",
          },
        },
      ],
    },
    {
      type: "Milestone",
      menuTitle: `${FILTER_BY_TEXT} Milestone`,
      menuList: [
        {
          text: "Unlabeled",
          clickHandler: null,
        },
        {
          text: "ETC",
          clickHandler: null,
        },
      ],
    },
    {
      type: "Assignee",
      menuTitle: `${FILTER_BY_TEXT} who's assigned`,
      menuList: [
        {
          text: "Unlabeled",
          clickHandler: null,
        },
        {
          text: "ETC",
          clickHandler: null,
        },
      ],
    },
  ];

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
