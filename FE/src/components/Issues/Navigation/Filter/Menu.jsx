import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";
import Popover from "@material-ui/core/Popover";
import PopupState, { bindTrigger, bindPopover } from "material-ui-popup-state";
import ArrowDropDownIcon from "@material-ui/icons/ArrowDropDown";
import MenuList from "@Components/common/MenuList";

const menuListText = [
  "Open issues",
  "Close issues",
  "Your issues",
  "Everything assigned to you",
  "Everything mentioning you",
  "Closed issues",
];
const FILTER_BTN_TEXT = "Filters";
const MENU_LIST_TITLE = "Filter Issues";

const Menu = () => {  
  const classes = useStyles();

  const menuList = mockArr.map((text) => <MenuList text={text} key={text} />);
  return (
    <PopupState variant="popover" popupId="demo-popup-popover">
      {(popupState) => (
        <Box>
          <Button
            disableElevation
            variant="contained"
            className={classes.button}
            {...bindTrigger(popupState)}
          >
            {FILTER_BTN_TEXT}
            <ArrowDropDownIcon />
          </Button>
          <Popover
            {...bindPopover(popupState)}
            anchorOrigin={{
              vertical: "bottom",
              horizontal: "left",
            }}
            transformOrigin={{
              vertical: "top",
              horizontal: "left",
            }}
          >
            <MenuList title={MENU_LIST_TITLE} />
            {menuList}
          </Popover>
        </Box>
      )}
    </PopupState>
  );
};

const useStyles = makeStyles((theme) => ({
  button: {
    backgroundColor: theme.palette.grey[100],
    border: `1px solid ${theme.palette.divider}`,
    borderRadius: "4px 0  0 4px",
    paddingRight: theme.spacing(1),
  },
}));

export default Menu;
