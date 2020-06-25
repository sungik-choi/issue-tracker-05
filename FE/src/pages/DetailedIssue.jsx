import React, { useContext } from "react";

// import LoadingIndicator from "@Components/common/LoadingIndicator";
import Header from "@Components/DetailedIssue/Header/Header";
import Comment from "@Components/DetailedIssue/Comment/Comment";
import Pickers from "@Components/DetailedIssue/Pickers/Pickers";

import Box from "@material-ui/core/Box";

import pipe from "@Utils/pipe";
import useFetch from "@Hooks/useFetch";

import { DetailedIssueContext } from "@Contexts/detailedIssueContext";
import { initDataFetchOptions } from "@Reducers/detailedIssueReducer";

const id = 1;
//라우팅 처리후 변경하기

const DetailedIssue = () => {
  const { detailedIssueDispatch } = useContext(DetailedIssueContext);
  const { loading } = pipe(initDataFetchOptions, useFetch)({ detailedIssueDispatch, id });

  return (
    <>
      {loading ? (
        "로딩중"
      ) : (
        <Box pt={5}>
          <Header />
          <Box display="flex" justifyContent="space-between">
            <Comment />
            <Pickers />
          </Box>
        </Box>
      )}
    </>
  );
};

export default DetailedIssue;
