import React, { useContext } from "react";

import Footer from "@Components/common/Footer";
import LoadingIndicator from "@Components/common/LoadingIndicator";
import IssueTable from "@Components/Issues/IssueTable/IssueTable";
import Navigation from "@Components/Issues/Navigation/Navigation";
import ClearButton from "@Components/Issues/ClearButton";

import { IssueListContext } from "@Contexts/issueListContext";
import { initialFetch } from "@Reducers/issueListReducer";

const Issues = () => {
  const { issueListDispatch } = useContext(IssueListContext);
  const loading = initialFetch(issueListDispatch);

  return (
    <>
      {loading ? (
        <LoadingIndicator />
      ) : (
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
