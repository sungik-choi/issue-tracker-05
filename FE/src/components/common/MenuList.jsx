import React from "react";
import PropTypes from "prop-types";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";

import CustomAvatar from "./CustomAvatar";
import Label from "./Label";

const MenuList = ({ text, title, clickHandler, options: { avatar, label } }) => {
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
          <CustomAvatar url={avatar.url} />
        </Box>
      )}
      {label && (
        <Box mr={1}>
          <Label name={label.name} backgroundColor={label.backgroundColor} color={label.color} />
        </Box>
      )}
      <Typography variant={textVariant}>{boxText}</Typography>
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
    label: null,
    avatar: null,
  },
};

MenuList.propTypes = {
  text: PropTypes.string,
  title: PropTypes.string,
  clickHandler: PropTypes.oneOfType([PropTypes.func, PropTypes.instanceOf(null)]),
  options: PropTypes.shape({
    avatar: PropTypes.shape({
      url: PropTypes.string.isRequired,
    }),
    name: PropTypes.string,
    label: PropTypes.shape({
      name: PropTypes.string.isRequired,
      backgroundColor: PropTypes.string.isRequired,
      color: PropTypes.string.isRequired,
    }),
  }),
};

export default MenuList;
