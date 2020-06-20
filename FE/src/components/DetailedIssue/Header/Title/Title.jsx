import React from "react";

import { data } from "@Mock/detailedIssue";
import Typography from "@material-ui/core/Typography";

const Title = () => {
  const title = data.issue.issueTitle;
  const id = data.issue.issueId;
  return (
    <div>
      <Typography variant="h3" component="h2">
        <span>{title}</span>
        <span>#{id}</span>
      </Typography>
    </div>
  );
};

export default Title;
