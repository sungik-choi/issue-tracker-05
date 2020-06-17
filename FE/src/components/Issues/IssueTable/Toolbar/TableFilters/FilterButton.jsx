import React from "react";
import PropTypes from "prop-types";

import Button from "@material-ui/core/Button";
import Popover from "@material-ui/core/Popover";
import PopupState, { bindTrigger, bindPopover } from "material-ui-popup-state";
import ArrowDropDownIcon from "@material-ui/icons/ArrowDropDown";

import MenuList from "@Components/common/MenuList";

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
            {menuList.map(({ text, clickHandler, ...options }) => (
              <MenuList key={text} text={text} clickHandler={clickHandler} options={options} />
            ))}
          </Popover>
        </div>
      )}
    </PopupState>
  );
};

FilterButton.propTypes = {
  type: PropTypes.string.isRequired,
  menuTitle: PropTypes.string.isRequired,
  menuList: PropTypes.arrayOf(
    PropTypes.shape({
      text: PropTypes.string.isRequired,
      clickHandler: PropTypes.oneOf([PropTypes.func, PropTypes.null]),
      options: PropTypes.any,
    }),
  ).isRequired,
};

export default FilterButton;
