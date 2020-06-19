import React, { useEffect, useContext } from "react";

import IssueTable from "@Components/Issues/IssueTable/IssueTable";
import Navigation from "@Components/Issues/Navigation/Navigation";
import ClearButton from "@Components/Issues/ClearButton";

import { IssueListContext } from "@Contexts/issueListContext";
import { fetchSuccess, fetchError } from "@Reducers/issueListReducer";

import useFetch from "@Hooks/useFetch";
import { issuesUrl } from "@Utils/urls";

const Issues = () => {
  const { issueList, issueListDispatch } = useContext(IssueListContext);

  useFetch({
    url: issuesUrl,
    actionType: {
      successAction: fetchSuccess,
      errorAction: fetchError,
    },
    dispatch: issueListDispatch,
  });

  useEffect(() => {
    console.log(issueList);
  }, [issueList]);

  return (
    <>
      <Navigation />
      <ClearButton />
      <IssueTable />
    </>
  );
};

export default Issues;
