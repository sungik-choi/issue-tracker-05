import React from "react";

import Popover from "@material-ui/core/Popover";
import PopupState, { bindTrigger, bindPopover } from "material-ui-popup-state";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import Divider from "@material-ui/core/Divider";
import IconButton from "@material-ui/core/IconButton";

import CustomAvatar from "@Components/common/CustomAvatar";

const UserMenu = () => {
  return (
    <PopupState variant="popover" popupId="demo-popup-popover">
      {(popupState) => (
        <>
          <IconButton {...bindTrigger(popupState)}>
            <CustomAvatar />
          </IconButton>
          <Popover
            {...bindPopover(popupState)}
            anchorOrigin={{
              vertical: "bottom",
              horizontal: "right",
            }}
            transformOrigin={{
              vertical: "top",
              horizontal: "right",
            }}
          >
            <List>
              <ListItem>
                <ListItemText primary="Sungik choi" />
              </ListItem>
              <Divider />
              <ListItem button>
                <ListItemText primary="Logout" />
              </ListItem>
            </List>
          </Popover>
        </>
      )}
    </PopupState>
  );
};

export default UserMenu;
