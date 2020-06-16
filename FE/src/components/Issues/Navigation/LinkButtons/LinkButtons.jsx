import React from "react";

import LinkButton from "./LinkButton";
import ButtonGroup from "@material-ui/core/ButtonGroup";

const labelCount = 8,
  milestonesCount = 3; //상태값으로 변경하기

const LinkButtons = () => {
  const LABELS = "Labels";
  const MILESTONES = "Milestones";

  return (
    <ButtonGroup aria-label="outlined primary button group">
      <LinkButton text={LABELS} count={labelCount} />
      <LinkButton text={MILESTONES} count={milestonesCount} />
    </ButtonGroup>
  );
};

export default LinkButtons;
