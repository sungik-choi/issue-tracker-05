import React from "react";

import LinkButton from "./LinkButton";
import ButtonGroup from "@material-ui/core/ButtonGroup";
import { makeStyles } from "@material-ui/core/styles";
import Button from "@material-ui/core/Button";

const labelCount = 8,
  milestonesCount = 3; //상태값으로 변경

const LinkButtons = () => {
  const LABELS = "Labels";
  const MILESTONES = "Milestones";

  const classes = useStyles();
  return (
    <div className={classes.root}>
      <ButtonGroup aria-label="outlined primary button group">
        <LinkButton text={LABELS} count={labelCount} />
        <LinkButton text={MILESTONES} count={milestonesCount} />
        <Button></Button>
      </ButtonGroup>
    </div>
  );
};

const useStyles = makeStyles((theme) => ({
  root: {
    // marginLeft: theme.spacing(5),
    // marginRight: theme.spacing(5),
  },
}));

export default LinkButtons;
