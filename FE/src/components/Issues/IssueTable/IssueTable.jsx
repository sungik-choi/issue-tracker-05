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
  const [selected, setSelected] = useState(new Set());

  const isSelected = (id) => selected.has(id);
  const handleCheckboxClick = (id) => {
    const updatedSet = new Set(selected);
    isSelected(id) ? updatedSet.delete(id) : updatedSet.add(id);
    setSelected(updatedSet);
  };

  const handleMenuClick = (e) => setAnchorEl(e.currentTarget);
  const handleMenuClose = () => setAnchorEl(null);

  const headContents = (
    <>
      <Box display="flex" alignItems="center">
        <Checkbox color="primary" />
        <Typography>{selected.size} selected</Typography>
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

  const bodyContents = [
    {
      id: 1,
      contents: <Issue id={1} isSelected={isSelected} clickHandler={handleCheckboxClick} />,
    },
    {
      id: 2,
      contents: <Issue id={2} isSelected={isSelected} clickHandler={handleCheckboxClick} />,
    },
  ];

  return (
    <CustomTable ariaLabel="issueTable" headContents={headContents} bodyContents={bodyContents} />
  );
};

export default IssueTable;
