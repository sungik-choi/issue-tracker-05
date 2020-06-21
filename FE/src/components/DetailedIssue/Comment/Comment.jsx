import React from "react";

import CustomTable from "@Components/common/CustomTable";
import ToolBar from "./ToolBar/ToolBar";
import { data } from "@Mock/detailedIssue";

import Box from "@material-ui/core/Box";
import { makeStyles, withStyles } from "@material-ui/core/styles";

const Comment = () => {
  const { userId, description } = data.issue.author;

  const contents = [{ id: userId, contents: description }];

  const classes = useStyles();

  return (
    <Box ml={"40px"} width="70%">
      <CustomTable headContents={<ToolBar />} bodyContents={contents} className={classes.table} />
    </Box>
  );
};

const useStyles = makeStyles(() => ({
  table: {
    "& th": {
      padding: "10px 20px",
    },
  },
}));

export default Comment;
