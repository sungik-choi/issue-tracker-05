import React, { useState } from "react";
import PropTypes from "prop-types";

import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import Menu from "@material-ui/core/Menu";
import MenuItem from "@material-ui/core/MenuItem";

const Toolbar = ({
  selectedIssueSize,
  bAtLeastOneSelectedIssue,
  bAllSelectedIssue,
  clickHandler,
}) => {
  const [anchorEl, setAnchorEl] = useState(null);

  const handleMenuClick = (event) => setAnchorEl(event.currentTarget);
  const handleMenuClose = () => setAnchorEl(null);

  return (
    <>
      <Box display="flex" alignItems="center">
        <Checkbox
          color="primary"
          indeterminate={bAtLeastOneSelectedIssue}
          checked={bAllSelectedIssue}
          onChange={clickHandler}
        />
        {!!selectedIssueSize && <Typography>{selectedIssueSize} selected</Typography>}
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
};

Toolbar.propTypes = {
  selectedIssueSize: PropTypes.number.isRequired,
  bAtLeastOneSelectedIssue: PropTypes.bool.isRequired,
  bAllSelectedIssue: PropTypes.bool.isRequired,
  clickHandler: PropTypes.func.isRequired,
};

export default Toolbar;
