import React, { useEffect, useContext } from "react";

import IssueTable from "@Components/Issues/IssueTable/IssueTable";
import Navigation from "@Components/Issues/Navigation/Navigation";
import ClearButton from "@Components/Issues/ClearButton";

import { IssueListContext } from "@Contexts/issueListContext";
import { fetchSuccess } from "@Reducers/issueListReducer";

import useFetch from "@Hooks/useFetch";

const url = "http://52.79.67.245/issues";

const Issues = () => {
  const { issueList, issueListDispatch } = useContext(IssueListContext);

  useFetch({
    url,
    actionType: fetchSuccess,
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
