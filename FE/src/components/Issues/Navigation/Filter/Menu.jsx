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
  popupBox: {
    width: "290px",
    padding: "8px 16px",
    cursor: "pointer",
    borderTop: "1px solid #e1e4e8",
    "&:hover": {
      backgroundColor: "#f6f8fa",
    },

    popupText: {
      fontSize: "10px",
    },
  },
}));

function PopoverPopupState() {
  const classes = useStyles();

  return (
    <PopupState variant="popover" popupId="demo-popup-popover">
      {(popupState) => (
        <div>
          <Button variant="contained" color="default" size="small" {...bindTrigger(popupState)}>
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
            <Box p={1} className={classes.popupBox}>
              <Typography>
                <span className={classes.popupText}>Filter lssues</span>
              </Typography>
            </Box>
            <Box p={1} className={classes.popupBox}>
              <Typography className={classes.popupText}>Open issues</Typography>
            </Box>
          </Popover>
        </div>
      )}
    </PopupState>
  );
}

export default Menu;
