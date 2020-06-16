import React, { useState } from "react";

import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import Menu from "@material-ui/core/Menu";
import MenuItem from "@material-ui/core/MenuItem";

import CustomTable from "@Components/common/CustomTable";
import Issue from "./Issue/Issue";

const IssueTable = () => {
  const [anchorEl, setAnchorEl] = useState(null);
  const [selectedIssue, setSelectedIssue] = useState(new Set());

  const isSelectedIssue = (id) => selectedIssue.has(id);

  const handleCheckboxClick = (id) => {
    const updatedSet = new Set(selectedIssue);
    isSelectedIssue(id) ? updatedSet.delete(id) : updatedSet.add(id);
    setSelectedIssue(updatedSet);
  };

  const handleAllCheckBoxClick = (event, issueList) => {
    if (event.target.checked) {
      const updatedSet = new Set(selectedIssue);
      issueList.forEach(({ id }) => updatedSet.add(id));
      setSelectedIssue(updatedSet);
      return;
    }
    setSelectedIssue(new Set());
  };

  const isSelectedIssueAtLeastOne = (issueList) =>
    selectedIssue.size > 0 && selectedIssue.size < issueList.length;

  const isAllSelectedIssue = (issueList) =>
    selectedIssue.size > 0 && selectedIssue.size === issueList.length;

  const handleMenuClick = (event) => setAnchorEl(event.currentTarget);

  const handleMenuClose = () => setAnchorEl(null);

  const issueList = [
    {
      id: 1,
      contents: (
        <Issue id={1} isSelectedIssue={isSelectedIssue} clickHandler={handleCheckboxClick} />
      ),
    },
    {
      id: 2,
      contents: (
        <Issue id={2} isSelectedIssue={isSelectedIssue} clickHandler={handleCheckboxClick} />
      ),
    },
  ];

  const toolbar = (
    <>
      <Box display="flex" alignItems="center">
        <Checkbox
          color="primary"
          indeterminate={isSelectedIssueAtLeastOne(issueList)}
          checked={isAllSelectedIssue(issueList)}
          onChange={(event) => handleAllCheckBoxClick(event, issueList)}
        />
        {!!selectedIssue.size && <Typography>{selectedIssue.size} selected</Typography>}
      </Box>
      <Button aria-controls="simple-menu" aria-haspopup="true" onClick={handleMenuClick}>
        Open Menu
      </Button>
      <Menu
        id="simple-menu"
        anchorEl={anchorEl}
        keepMounted
        open={!!anchorEl}
        onClose={handleMenuClose}
      >
        <MenuItem onClick={handleMenuClose}>Profile</MenuItem>
        <MenuItem onClick={handleMenuClose}>My account</MenuItem>
        <MenuItem onClick={handleMenuClose}>Logout</MenuItem>
      </Menu>
    </>
  );

  return <CustomTable ariaLabel="issueTable" headContents={toolbar} bodyContents={issueList} />;
};

export default IssueTable;
