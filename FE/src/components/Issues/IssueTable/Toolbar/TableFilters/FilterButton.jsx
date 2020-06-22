import React from "react";
import PropTypes from "prop-types";

import Button from "@material-ui/core/Button";
import Popover from "@material-ui/core/Popover";
import PopupState, { bindTrigger, bindPopover } from "material-ui-popup-state";
import ArrowDropDownIcon from "@material-ui/icons/ArrowDropDown";

import MenuList from "@Components/common/MenuList";

const FilterButton = ({ type, clearMenu, menuTitle, menuList }) => {
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
            {clearMenu && <MenuList text={clearMenu.text} clickHandler={clearMenu.clickHandler} />}
            {menuList.map(({ id, text, clickHandler, ...options }) => (
              <MenuList key={id} text={text} clickHandler={clickHandler} options={options} />
            ))}
          </Popover>
        </div>
      )}
    </PopupState>
  );
};

FilterButton.defaultProps = {
  clearMenu: null,
};

FilterButton.propTypes = {
  type: PropTypes.string.isRequired,
  menuTitle: PropTypes.string.isRequired,
  clearMenu: PropTypes.oneOfType([
    PropTypes.shape({
      text: PropTypes.string.isRequired,
      clickHandler: PropTypes.func.isRequired,
    }),
    PropTypes.instanceOf(null),
  ]),
  menuList: PropTypes.arrayOf(
    PropTypes.shape({
      text: PropTypes.string.isRequired,
      clickHandler: PropTypes.oneOfType([PropTypes.func, PropTypes.instanceOf(null)]),
      options: PropTypes.any,
    }),
  ).isRequired,
};

export default FilterButton;
