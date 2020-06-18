import React from "react";

import IssueTable from "@Components/Issues/IssueTable/IssueTable";
import Navigation from "@Components/Issues/Navigation/Navigation";
import ClearButton from "@Components/Issues/ClearButton";

const Issues = () => {
  return (
    <>
      <Navigation />
      <ClearButton />
      <IssueTable />
    </>
  );
};

export default Issues;
