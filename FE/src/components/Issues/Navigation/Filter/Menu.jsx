import React from "react";

import Typography from "@material-ui/core/Typography";
import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";
import Popover from "@material-ui/core/Popover";
import PopupState, { bindTrigger, bindPopover } from "material-ui-popup-state";
import ArrowDropDownIcon from "@material-ui/icons/ArrowDropDown";
import { makeStyles } from "@material-ui/core/styles";

const Menu = () => {
  return (
    <>
      <PopoverPopupState />
    </>
  );
};

const useStyles = makeStyles((theme) => ({
  filterText: {
    fontSize: "13px",
    fontWeight: "bold",
  },
  downIcon: {
    verticalAlign: "middle",
  },
}));

function PopoverPopupState() {
  const classes = useStyles();

  return (
    <PopupState variant="popover" popupId="demo-popup-popover">
      {(popupState) => (
        <div>
          <Button variant="contained" color="default" {...bindTrigger(popupState)}>
            <span className={classes.filterText}>
              Filters
              <ArrowDropDownIcon className={classes.downIcon} />
            </span>
          </Button>
          <Popover
            {...bindPopover(popupState)}
            anchorOrigin={{
              vertical: "bottom",
              horizontal: "center",
            }}
            transformOrigin={{
              vertical: "top",
              horizontal: "center",
            }}
          >
            <Box p={2}>
              <Typography>The content of the Popover.</Typography>
            </Box>
          </Popover>
        </div>
      )}
    </PopupState>
  );
}

export default Menu;
