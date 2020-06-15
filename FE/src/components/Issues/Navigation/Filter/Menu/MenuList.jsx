import React from "react";

import Typography from "@material-ui/core/Typography";
import Box from "@material-ui/core/Box";
import { makeStyles } from "@material-ui/core/styles";

const MenuList = ({ text }) => {
  const classes = useStyles();

  return (
    <Box p={1} className={classes.popupBox}>
      <Typography style={{ fontSize: "13px" }}>{text}</Typography>
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
}));

export default MenuList;
