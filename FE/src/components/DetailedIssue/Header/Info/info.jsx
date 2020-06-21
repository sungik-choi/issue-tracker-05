import React from "react";

import StatusIcon from "@Components/Common/StatusIcon";
import PrimaryButton from "@Components/Common/PrimaryButton";
import { data } from "@Mock/detailedIssue";

// context로 closed상태 가져옴

const Info = () => {
  const isOpened = data.issue.isOpened;

  return (
    <div>
      {isOpened ? (
        <PrimaryButton text="Open" startIcon={<StatusIcon />} />
      ) : (
        <PrimaryButton text="Closed" color="secondary" startIcon={<StatusIcon closed />} />
      )}
    </div>
  );
};

export default Info;
