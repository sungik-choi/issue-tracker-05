import React from "react";

import MenuList from "../../../common/MenuList";

import Button from "@material-ui/core/Button";
import Popover from "@material-ui/core/Popover";
import PopupState, { bindTrigger, bindPopover } from "material-ui-popup-state";
import ArrowDropDownIcon from "@material-ui/icons/ArrowDropDown";
import { makeStyles } from "@material-ui/core/styles";

const mockArr = ["Filter lssues", "Open issues", "Close issues"];
const MENU_LIST_TITLE = "Filter lssues";

const Menu = () => {
  const menuList = mockArr.map((text) => <MenuList text={text} />);

  return (
    <>
      <PopoverPopupState menuList={menuList} />
    </>
  );
};

const PopoverPopupState = ({ menuList }) => {
  const classes = useStyles();

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
            <MenuList title={MENU_LIST_TITLE} />
            {menuList}
          </Popover>
        </div>
      )}
    </PopupState>
  );
};

const useStyles = makeStyles((theme) => ({
  button: {
    border: "var(--button-border)",
  },
  filterText: {
    fontSize: "13px",
    fontWeight: "bold",
  },
  downIcon: {
    verticalAlign: "middle",
  },
}));

export default Menu;
