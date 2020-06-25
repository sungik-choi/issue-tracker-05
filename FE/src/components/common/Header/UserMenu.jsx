import React, { useContext } from "react";
import PropTypes from "prop-types";
import { useCookies } from "react-cookie";
import pipe from "@Utils/pipe";

import Popover from "@material-ui/core/Popover";
import PopupState, { bindTrigger, bindPopover } from "material-ui-popup-state";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText";
import Divider from "@material-ui/core/Divider";
import IconButton from "@material-ui/core/IconButton";
import AccountCircleOutlinedIcon from "@material-ui/icons/AccountCircleOutlined";
import ExitToAppOutlinedIcon from "@material-ui/icons/ExitToAppOutlined";

import { UserContext } from "@Contexts/userContext";
import { deleteUserData } from "@Reducers/userReducer";

import CustomAvatar from "@Components/common/CustomAvatar";

import { TOKEN } from "@Constants/constants";

const SIGN_OUT = "Sign out";

const UserMenu = ({ userId, url }) => {
  const [, , removeCookie] = useCookies([TOKEN]);
  const { userDispatch } = useContext(UserContext);

  const signOutHandler = () => pipe(removeCookie, deleteUserData, userDispatch)(TOKEN);

  return (
    <PopupState variant="popover" popupId="demo-popup-popover">
      {(popupState) => (
        <>
          <IconButton {...bindTrigger(popupState)}>
            <CustomAvatar userId={userId} url={url} />
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
                <ListItemIcon>
                  <AccountCircleOutlinedIcon />
                </ListItemIcon>
                <ListItemText primary={userId} />
              </ListItem>
              <Divider />
              <ListItem button onClick={signOutHandler}>
                <ListItemIcon>
                  <ExitToAppOutlinedIcon />
                </ListItemIcon>
                <ListItemText primary={SIGN_OUT} />
              </ListItem>
            </List>
          </Popover>
        </>
      )}
    </PopupState>
  );
};

UserMenu.propTypes = {
  userId: PropTypes.string.isRequired,
  url: PropTypes.string.isRequired,
};

export default UserMenu;
