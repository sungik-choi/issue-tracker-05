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
    width: "250px",
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
