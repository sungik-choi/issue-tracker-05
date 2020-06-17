import React from "react";
import PropTypes from "prop-types";

import Button from "@material-ui/core/Button";
import Popover from "@material-ui/core/Popover";
import PopupState, { bindTrigger, bindPopover } from "material-ui-popup-state";

import MenuList from "@Components/common/MenuList";
import ArrowDropDownIcon from "@material-ui/icons/ArrowDropDown";

const FilterButton = ({ type, menuTitle, menuList }) => {
  return (
    <PopupState variant="popover" popupId={type}>
      {(popupState) => (
        <div>
          <Button {...bindTrigger(popupState)}>
            {type}
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
            <MenuList title={menuTitle} />
            {menuList.map(({ text, clickHandler }) => (
              <MenuList key={text} text={text} clickHandler={clickHandler} />
            ))}
          </Popover>
        </div>
      )}
    </PopupState>
  );
};

FilterButton.propTypes = {
  type: PropTypes.string.isRequired,
};

export default FilterButton;
