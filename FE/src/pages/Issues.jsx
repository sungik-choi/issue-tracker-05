import React, { useContext } from "react";

import IssueTable from "@Components/Issues/IssueTable/IssueTable";
import Navigation from "@Components/Issues/Navigation/Navigation";
import ClearButton from "@Components/Issues/ClearButton";

// import { IssuesProvider, IssuesContext } from "@Contexts/issuesContext";
import { fetchSuccess, fetchError } from "@Reducers/issuesReducer";

const url = "http://52.79.67.245/api/issues";

const Issues = () => {
  fetch(url)
    .then((res) => res.json())
    .then((initialData) => console.log(initialData));

  return (
    <>
      <Navigation />
      <ClearButton />
      <IssueTable />
    </>
  );
};

export default Issues;
