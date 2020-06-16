import React, { useState } from "react";

import CustomTable from "@Components/common/CustomTable";
import Toolbar from "./Toolbar/Toolbar";
import Issue from "./Issue/Issue";

const IssueTable = () => {
  const [selectedIssue, setSelectedIssue] = useState(new Set());

  const selectedIssueSize = selectedIssue.size;
  const isSelectedIssue = (id) => selectedIssue.has(id);
  const isAtLeastOneSelectedIssue = (issueList) =>
    selectedIssueSize > 0 && selectedIssueSize < issueList.length;
  const isAllSelectedIssue = (issueList) =>
    selectedIssueSize > 0 && selectedIssueSize === issueList.length;

  const handleCheckboxClick = (id) => {
    const updatedSet = new Set(selectedIssue);
    isSelectedIssue(id) ? updatedSet.delete(id) : updatedSet.add(id);
    setSelectedIssue(updatedSet);
  };

  const handleAllCheckBoxClick = (event, issueList) => {
    if (event.target.checked) {
      const updatedSet = new Set(selectedIssue);
      issueList.forEach(({ id }) => updatedSet.add(id));
      setSelectedIssue(updatedSet);
      return;
    }
    setSelectedIssue(new Set());
  };

  const issueList = [
    {
      id: 1,
      contents: (
        <Issue id={1} isSelectedIssue={isSelectedIssue} clickHandler={handleCheckboxClick} />
      ),
    },
    {
      id: 2,
      contents: (
        <Issue id={2} isSelectedIssue={isSelectedIssue} clickHandler={handleCheckboxClick} />
      ),
    },
  ];

  const toolbar = (
    <Toolbar
      selectedIssueSize={selectedIssueSize}
      bAtLeastOneSelectedIssue={isAtLeastOneSelectedIssue(issueList)}
      bAllSelectedIssue={isAllSelectedIssue(issueList)}
      clickHandler={(event) => handleAllCheckBoxClick(event, issueList)}
    />
  );

  return <CustomTable ariaLabel="issueTable" headContents={toolbar} bodyContents={issueList} />;
};

export default IssueTable;
