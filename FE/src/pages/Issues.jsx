import React, { useContext } from "react";

import Box from "@material-ui/core/Box";

import IssueTable from "@Components/Issues/IssueTable/IssueTable";
import Navigation from "@Components/Issues/Navigation/Navigation";
import ClearButton from "@Components/Issues/ClearButton";

import { IssueListContext } from "@Contexts/issueListContext";
import { fetchSuccess, fetchError } from "@Reducers/issueListReducer";

import useFetch from "@Hooks/useFetch";
import { issuesUrl } from "@Utils/urls";

const Issues = () => {
  const { issueListDispatch } = useContext(IssueListContext);

  const loading = useFetch({
    url: issuesUrl,
    actionType: {
      successAction: fetchSuccess,
      errorAction: fetchError,
    },
    dispatch: issueListDispatch,
  });

  return (
    <>
      {!loading && (
        <Box pb={10}>
          <Navigation />
          <ClearButton />
          <IssueTable />
        </Box>
      )}
    </>
  );
};

export default Issues;
