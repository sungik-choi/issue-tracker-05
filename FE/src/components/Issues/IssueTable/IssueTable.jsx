import React, { useState, useContext } from "react";

import { IssueListContext } from "@Contexts/issueListContext";

import CustomTable from "@Components/common/CustomTable";
import Toolbar from "./Toolbar/Toolbar";
import Issue from "./Issue/Issue";

const IssueTable = () => {
  const [selectedIssue, setSelectedIssue] = useState(new Set());

  const selectedIssueSize = selectedIssue.size;
  const isSelectedIssue = (id) => {
    console.log(id, selectedIssue.has(id));
    return selectedIssue.has(id);
  };
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

  const {
    issueList: { issues },
  } = useContext(IssueListContext);

  const issueList = issues.reduce((accumulator, { id, ...data }) => {
    return [
      ...accumulator,
      {
        id,
        contents: (
          <Issue
            id={id}
            data={data}
            isSelectedIssue={isSelectedIssue(id)}
            clickHandler={() => handleCheckboxClick(id)}
          />
        ),
      },
    ];
  }, []);

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
