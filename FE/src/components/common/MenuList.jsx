import React from "react";
import PropTypes from "prop-types";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";

import CustomAvatar from "./CustomAvatar";

const MenuList = ({ text, title, clickHandler, options: { avatar, name } }) => {
  const classes = useStyles();

  const boxClassName = title ? classes.titleBox : classes.popupBox;
  const boxText = title || text;
  const textVariant = title ? "subtitle2" : "body2";

  return (
    <Box
      display="flex"
      alignItems="center"
      py={1}
      px={2}
      className={boxClassName}
      onClick={clickHandler}
    >
      {avatar && (
        <Box mr={1}>
          <CustomAvatar id={avatar.id} url={avatar.url} />
        </Box>
      )}
      <Typography variant={textVariant}>{boxText}</Typography>
      {name && (
        <Box ml={2}>
          <Typography variant={textVariant} color="textSecondary">
            {name}
          </Typography>
        </Box>
      )}
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  popupBox: {
    width: 250,
    cursor: "pointer",
    borderTop: `1px solid ${theme.palette.divider}`,
    "&:hover": {
      backgroundColor: theme.palette.action.hover,
    },
  },
  titleBox: {
    backgroundColor: theme.palette.grey[100],
  },
}));

MenuList.defaultProps = {
  text: "",
  title: "",
  clickHandler: null,
  options: {
    name: "",
    avatar: null,
  },
};

MenuList.propTypes = {
  text: PropTypes.string,
  title: PropTypes.string,
  clickHandler: PropTypes.func,
  options: PropTypes.shape({
    avatar: PropTypes.shape({
      id: PropTypes.string.isRequired,
      url: PropTypes.string.isRequired,
    }),
    name: PropTypes.string,
  }),
};

export default MenuList;
