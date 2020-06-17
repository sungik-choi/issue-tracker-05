import React from "react";
import PropTypes from "prop-types";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";

const MenuList = ({ text, title, clickHandler }) => {
  const classes = useStyles();

  const boxClassName = title ? classes.titleBox : classes.popupBox;
  const boxText = title || text;
  const boxFontWeight = title ? "bold" : "none";

  return (
    <Box py={1} px={2} className={boxClassName} onClick={clickHandler}>
      <Typography style={{ fontSize: "13px", fontWeight: boxFontWeight }}>{boxText}</Typography>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  popupBox: {
    width: 250,
    cursor: "pointer",
    borderTop: `1px solid${theme.palette.grey[300]}`,
    "&:hover": {
      backgroundColor: theme.palette.grey[200],
    },
  },
  titleBox: {
    backgroundColor: theme.palette.grey[200],
  },
}));

MenuList.defaultProps = {
  text: "",
  title: "",
  clickHandler: null,
};

MenuList.propTypes = {
  text: PropTypes.string,
  title: PropTypes.string,
  clickHandler: PropTypes.func,
};

export default MenuList;

// 사용 용도는 두 가지가 있습니다
// 1. title로써 상단에 사용
// 2. menuList로써 hover와 마우스 클릭이 되는 list로 사용
// title로 사용 시 : props로 title을 사용하고 title에 들어갈 text를 넣어주면 됩니다.
// (예) <MenuList title="Filter lssues" />
// menuList로 사용 시 : props로 text를 사용하고 list에 들어갈 text를 넣어주면 됩니다.
// (예) <MenuList text="Open issues" />
