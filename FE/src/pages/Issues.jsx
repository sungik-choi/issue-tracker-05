import React, { useContext } from "react";

import IssueTable from "@Components/Issues/IssueTable/IssueTable";
import Navigation from "@Components/Issues/Navigation/Navigation";
import ClearButton from "@Components/Issues/ClearButton";

import { IssuesContext } from "@Contexts/issuesContext";
import { fetchSuccess, fetchError } from "@Reducers/issuesReducer";

const Issues = () => {
  const { issues, issuesDispatch } = useContext(IssuesContext);

  return (
    <>
      <Navigation />
      <ClearButton />
      <IssueTable />
    </>
  );
};

export default Issues;
