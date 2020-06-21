import React from "react";

import StatusIcon from "@Components/Common/StatusIcon";
import PrimaryButton from "@Components/Common/PrimaryButton";

const Info = () => {
  return (
    <div>
      <PrimaryButton text="Open" startIcon={<StatusIcon />} />
    </div>
  );
};

export default Info;
