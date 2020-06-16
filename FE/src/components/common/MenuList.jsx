import React from "react";

import Typography from "@material-ui/core/Typography";
import Box from "@material-ui/core/Box";
import { makeStyles } from "@material-ui/core/styles";

const MenuList = ({ text, title }) => {
  const classes = useStyles();

  const boxClassName = title ? classes.titleBox : classes.popupBox;
  const boxText = title ? title : text;
  const boxFontWeight = title ? "bold" : "none";

  return (
    <Box p={1} className={boxClassName}>
      <Typography style={{ fontSize: "13px", fontWeight: boxFontWeight }}>{boxText}</Typography>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  popupBox: {
    width: 250,
    padding: "8px 16px",
    cursor: "pointer",
    borderTop: "1px solid #e1e4e8",
    "&:hover": {
      backgroundColor: "var(--popup-backgroundColor)",
    },
  },
  titleBox: {
    backgroundColor: "var(--popup-backgroundColor)",
    padding: "8px 16px",
  },
}));

export default MenuList;

// 사용 용도는 두 가지가 있습니다
// 1. title로써 상단에 사용
// 2. menuList로써 hover와 마우스 클릭이 되는 list로 사용
// title로 사용 시 : props로 title을 사용하고 title에 들어갈 text를 넣어주면 됩니다.
// (예) <MenuList title={"Filter lssues"} />
//menuList로 사용 시 : props로 text를 사용하고 list에 들어갈 text를 넣어주면 됩니다.
// (예) <MenuList text={"Open issues"} />
