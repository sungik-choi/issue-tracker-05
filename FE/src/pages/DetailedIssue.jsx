import React from "react";

import Header from "@Components/DetailedIssue/Header/Header";
import Comment from "@Components/DetailedIssue/Comment/Comment";

import Box from "@material-ui/core/Box";

import pipe from "@Utils/pipe";
import useFetch from "@Hooks/useFetch";

import { detailedIssueDispatch } from "@Contexts/detailedIssueContext";
import { initDataFetchOptions } from "@Reducers/detailedIssueReducer";

const DetailedIssue = () => {
  const { loading, getData } = pipe(initDataFetchOptions, useFetch)(detailedIssueDispatch);
  return (
    <Box pt={5}>
      <Header />
      <Comment />
    </Box>
  );
};

export default DetailedIssue;
