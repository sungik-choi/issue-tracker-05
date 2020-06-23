import React, { useContext } from "react";

import Footer from "@Components/common/Footer";
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
        <>
          <Navigation />
          <ClearButton />
          <IssueTable />
          <Footer />
        </>
      )}
    </>
  );
};

export default Issues;
