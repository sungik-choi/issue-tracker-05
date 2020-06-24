import React from "react";

import Header from "@Components/DetailedIssue/Header/Header";
import Comment from "@Components/DetailedIssue/Comment/Comment";

import Box from "@material-ui/core/Box";

const DetailedIssue = () => {
  return (
    <Box pt={5}>
      <Header />
      <Comment />
    </Box>
  );
};

export default DetailedIssue;
