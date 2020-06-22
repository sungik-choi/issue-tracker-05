import React from "react";

import CustomAvatar from "@Components/Common/CustomAvatar";
import CustomTable from "@Components/common/CustomTable";
import ToolBar from "./ToolBar/ToolBar";
import { data } from "@Mock/detailedIssue";

import Box from "@material-ui/core/Box";
import { makeStyles } from "@material-ui/core/styles";

const Table = ({ children, userId, avatarUrl }) => {
  const classes = useStyles();

  return (
    <Box position="relative" mb={4}>
      <CustomAvatar id={userId} url={avatarUrl} className={classes.avatar} />
      <Box ml={"40px"} width="70%">
        {children}
      </Box>
    </Box>
  );
};

const useStyles = makeStyles(() => ({
  avatar: {
    position: "absolute",
    top: 3,
    left: -5,
  },
  table: {
    "& th": {
      padding: "3px 20px",
    },
    "& .MuiTableRow-hover": {
      pointerEvents: "none",
    },
  },
}));

export default Table;
