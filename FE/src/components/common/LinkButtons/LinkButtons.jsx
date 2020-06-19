import React, { useContext } from "react";

import ButtonGroup from "@material-ui/core/ButtonGroup";
import LocalOfferOutlinedIcon from "@material-ui/icons/LocalOfferOutlined";
import OutlinedFlagIcon from "@material-ui/icons/OutlinedFlag";

import { IssueListContext } from "@Contexts/issueListContext";

import LinkButton from "./LinkButton";

const LinkButtons = () => {
  const LABELS = "Labels";
  const MILESTONES = "Milestones";

  const {
    issueList: {
      labelInfo: { countOfLabel },
      milestoneInfo: { countOfMilestone },
    },
  } = useContext(IssueListContext);

  return (
    <ButtonGroup variant="outlined">
      <LinkButton text={LABELS} icon={<LocalOfferOutlinedIcon />} count={countOfLabel} />
      <LinkButton text={MILESTONES} icon={<OutlinedFlagIcon />} count={countOfMilestone} />
    </ButtonGroup>
  );
};

export default LinkButtons;
