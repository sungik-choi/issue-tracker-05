import React from "react";

import MenuList from "@Components/common/MenuList";

import Button from "@material-ui/core/Button";
import Popover from "@material-ui/core/Popover";
import PopupState, { bindTrigger, bindPopover } from "material-ui-popup-state";
import ArrowDropDownIcon from "@material-ui/icons/ArrowDropDown";
import { makeStyles } from "@material-ui/core/styles";
import grey from "@material-ui/core/colors/grey";

const mockArr = ["Filter lssues", "Open issues", "Close issues"];
const MENU_LIST_TITLE = "Filter lssues";

const Menu = () => {
  const FILTER_BTN_TEXT = "Filters";
  const classes = useStyles();

  const menuList = mockArr.map((text) => <MenuList text={text} key={text} />);
  return (
    <PopupState variant="popover" popupId="demo-popup-popover">
      {(popupState) => (
        <div>
          <Button
            className={classes.button}
            variant="contained"
            color="default"
            size="small"
            {...bindTrigger(popupState)}
          >
            <span className={classes.filterText}>{FILTER_BTN_TEXT}</span>
            <span>
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
            <MenuList title={MENU_LIST_TITLE} />
            {menuList}
          </Popover>
        </div>
      )}
    </PopupState>
  );
};

const useStyles = makeStyles(() => ({
  button: {
    border: `1px solid${grey[400]}`,
    borderRadius: "5px 0  0 5px",
    textTransform: "none",
  },
  filterText: {
    fontSize: 13,
    fontWeight: "bold",
  },
  downIcon: {
    verticalAlign: "middle",
  },
}));

export default Menu;
