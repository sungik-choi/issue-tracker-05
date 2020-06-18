import React from "react";

import ButtonGroup from "@material-ui/core/ButtonGroup";
import LocalOfferOutlinedIcon from "@material-ui/icons/LocalOfferOutlined";
import OutlinedFlagIcon from "@material-ui/icons/OutlinedFlag";

import LinkButton from "./LinkButton";

const labelCount = 8;
const milestonesCount = 3; // 상태값으로 변경하기

const LinkButtons = () => {
  const LABELS = "Labels";
  const MILESTONES = "Milestones";

  return (
    <ButtonGroup variant="outlined">
      <LinkButton text={LABELS} icon={<LocalOfferOutlinedIcon />} count={labelCount} />
      <LinkButton text={MILESTONES} icon={<OutlinedFlagIcon />} count={milestonesCount} />
    </ButtonGroup>
  );
};

export default LinkButtons;
