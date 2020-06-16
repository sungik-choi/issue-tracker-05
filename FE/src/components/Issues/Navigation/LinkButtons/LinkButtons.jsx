import React from "react";

import LinkButton from "./LinkButton";

const labelCount = 8,
  milestonesCount = 3; //상태값으로 변경

const LinkButtons = () => {
  const LABELS = "Labels";
  const MILESTONES = "Milestones";
  console.log(LABELS, 1);

  return (
    <>
      <LinkButton text={LABELS} count={labelCount} />
      <LinkButton text={MILESTONES} count={milestonesCount} />
    </>
  );
};

export default LinkButtons;
