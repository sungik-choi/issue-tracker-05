import React from "react";

import CustomTable from "@Components/common/CustomTable";
import ToolBar from "./ToolBar/ToolBar";

import Box from "@material-ui/core/Box";

const Comment = () => {
  return (
    <Box ml={"40px"} border="1px solid red" width="70%">
      <ToolBar />
    </Box>
  );
};

export default Comment;
