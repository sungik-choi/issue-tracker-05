import React, { useContext } from "react";

import useFetch from "@Hooks/useFetch";
import pipe from "@Utils/pipe";

import Footer from "@Components/common/Footer";
import LoadingIndicator from "@Components/common/LoadingIndicator";
import IssueTable from "@Components/Issues/IssueTable/IssueTable";
import Navigation from "@Components/Issues/Navigation/Navigation";
import ClearButton from "@Components/Issues/ClearButton";

import { IssueListContext } from "@Contexts/issueListContext";
import { initDataFetchOptions } from "@Reducers/issueListReducer";

const Issues = () => {
  const { issueListDispatch } = useContext(IssueListContext);
  const { loading } = pipe(initDataFetchOptions, useFetch)(issueListDispatch);

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
