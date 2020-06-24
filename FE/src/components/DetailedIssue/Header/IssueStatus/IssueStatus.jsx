import React from "react";

import StatusIcon from "@Components/common/StatusIcon";
import { data } from "@Mock/detailedIssue";

import calcTimeDiff from "@Utils/calcTimeDiff";

import Typography from "@material-ui/core/Typography";
import Box from "@material-ui/core/Box";
import Chip from "@material-ui/core/Chip";
import { makeStyles } from "@material-ui/core/styles";

// context로 data 가져옴

const IssueStatus = () => {
  const OPEN_TEXT = "Open";
  const CLOSE_TEXT = "Close";

  const {
    isOpened,
    createdAt,
    author: { userName },
  } = data.issue;
  const { countOfComment } = data.issue.commentInfo;

  const classes = useStyles();
  const time = calcTimeDiff(createdAt);

  const statusMessage = `opened this issue ${time} ago · ${countOfComment} comment`;

  return (
    <Box display="flex" alignItems="center" mt={1}>
      {isOpened ? (
        <Chip color="primary" label={OPEN_TEXT} icon={<StatusIcon color="white" />} />
      ) : (
        <Chip color="secondary" label={CLOSE_TEXT} icon={<StatusIcon color="white" closed />} />
      )}
      <Typography color="textSecondary" variant="subtitle1" component="div">
        <strong className={classes.userName}>{userName}</strong>
        {statusMessage}
      </Typography>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  userName: {
    marginLeft: theme.spacing(2),
    marginRight: theme.spacing(1),
    fontWeight: "bold",
  },
}));

export default IssueStatus;
