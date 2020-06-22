import React, { useContext } from "react";
import PropTypes from "prop-types";

import Box from "@material-ui/core/Box";

import { IssueListContext } from "@Contexts/issueListContext";

import FilterButton from "./FilterButton";

const TableFilters = ({ bSelectedIssueExist }) => {
  const {
    issueList: {
      labelInfo: { labels },
      milestoneInfo: { milestones },
      users,
    },
  } = useContext(IssueListContext);

  const FILTER_BY_TEXT = "Filter by";
  const AUTHOR = "author";
  const LABEL = "Label";
  const MILESTONES = "Milestones";
  const ASSIGNEE = "Assignee";

  const userFilterList = users.reduce((accumulator, { id, name, avatarUrl }) => {
    return [
      ...accumulator,
      {
        id,
        text: name,
        avatar: {
          url: avatarUrl,
        },
        clickHandler: null,
      },
    ];
  }, []);

  const labelFilterList = labels.reduce((accumulator, { id, name, backgroundColor, color }) => {
    return [
      ...accumulator,
      {
        id,
        text: name,
        label: {
          name,
          backgroundColor,
          color,
        },
        clickHandler: null,
      },
    ];
  }, []);

  const milestoneFilterList = milestones.reduce((accumulator, { id, title }) => {
    return [
      ...accumulator,
      {
        id,
        text: title,
        clickHandler: null,
      },
    ];
  }, []);

  const assigneeFilterList = userFilterList.map((user) => ({ ...user, clickHandler: null }));

  const filterButtonList = [
    {
      type: `${AUTHOR}`,
      menuTitle: `${FILTER_BY_TEXT} ${AUTHOR}`,
      menuList: userFilterList,
    },
    {
      type: `${LABEL}`,
      menuTitle: `${FILTER_BY_TEXT} ${LABEL}`,
      menuList: labelFilterList,
      clearMenu: {
        text: "Unlabeled",
        clickHandler: null,
      },
    },
    {
      type: `${MILESTONES}`,
      menuTitle: `${FILTER_BY_TEXT} ${MILESTONES}`,
      menuList: milestoneFilterList,
      clearMenu: {
        text: "Issues with no milestones",
        clickHandler: null,
      },
    },
    {
      type: `${ASSIGNEE}`,
      menuTitle: `${FILTER_BY_TEXT} ${ASSIGNEE}`,
      menuList: assigneeFilterList,
      clearMenu: {
        text: "Assigned to nobody",
        clickHandler: null,
      },
    },
  ];

  const markAsFilterButton = {
    type: "Mark as",
    menuTitle: "Actions",
    menuList: [
      {
        text: "Open",
        clickHandler: null,
      },
      {
        text: "Close",
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
        filterButtonList.map(({ type, clearMenu, menuTitle, menuList }) => (
          <FilterButton
            key={type}
            type={type}
            clearMenu={clearMenu}
            menuTitle={menuTitle}
            menuList={menuList}
          />
        ))
      )}
    </Box>
  );
};

TableFilters.propTypes = {
  bSelectedIssueExist: PropTypes.bool.isRequired,
};

export default TableFilters;
