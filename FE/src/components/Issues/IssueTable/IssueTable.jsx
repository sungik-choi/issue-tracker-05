import React, { useState } from "react";

import Box from "@material-ui/core/Box";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import Menu from "@material-ui/core/Menu";
import MenuItem from "@material-ui/core/MenuItem";

import CustomTable from "@Components/CustomTable";
import IssueList from "./IssueList/IssueList";

const IssueTable = () => {
  const [anchorEl, setAnchorEl] = useState(null);

  const handleClick = (e) => setAnchorEl(e.currentTarget);
  const handleClose = () => setAnchorEl(null);

  const headContents = (
    <>
      <Checkbox color="primary" />
      <Box>
        <Button aria-controls="simple-menu" aria-haspopup="true" onClick={handleClick}>
          Open Menu
        </Button>
        <Menu
          id="simple-menu"
          anchorEl={anchorEl}
          keepMounted
          open={!!anchorEl}
          onClose={handleClose}
        >
          <MenuItem onClick={handleClose}>Profile</MenuItem>
          <MenuItem onClick={handleClose}>My account</MenuItem>
          <MenuItem onClick={handleClose}>Logout</MenuItem>
        </Menu>
      </Box>
    </>
  );

  const bodyContents = [
    {
      id: 1,
      contents: <IssueList />,
    },
    {
      id: 2,
      contents: <IssueList />,
    },
  ];

  return (
    <CustomTable ariaLabel="issueTable" headContents={headContents} bodyContents={bodyContents} />
  );
};

export default IssueTable;
