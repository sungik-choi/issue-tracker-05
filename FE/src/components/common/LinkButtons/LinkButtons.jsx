import React from "react";
import PropTypes from "prop-types";

import ButtonGroup from "@material-ui/core/ButtonGroup";
import LocalOfferOutlinedIcon from "@material-ui/icons/LocalOfferOutlined";
import OutlinedFlagIcon from "@material-ui/icons/OutlinedFlag";

import LinkButton from "./LinkButton";

const LinkButtons = ({ labelCount, milestoneCount, activeButton }) => {
  const LABELS = "Labels";
  const MILESTONES = "Milestones";
  const isLabelButtonActivated = activeButton === "labels";
  const isMilestonesButtonActivated = activeButton === "milestones";

  return (
    <ButtonGroup variant="outlined">
      <LinkButton
        color={isLabelButtonActivated && "primary"}
        text={LABELS}
        icon={<LocalOfferOutlinedIcon />}
        count={labelCount}
        variant={isLabelButtonActivated && "contained"}
        disableElevation
      />
      <LinkButton
        color={isMilestonesButtonActivated && "primary"}
        text={MILESTONES}
        icon={<OutlinedFlagIcon />}
        count={milestoneCount}
        variant={isMilestonesButtonActivated && "contained"}
        disableElevation
      />
    </ButtonGroup>
  );
};

LinkButtons.defaultProps = {
  labelCount: null,
  milestoneCount: null,
  activeButton: "",
};

LinkButtons.propTypes = {
  labelCount: PropTypes.oneOfType([PropTypes.number, PropTypes.instanceOf(null)]),
  milestoneCount: PropTypes.oneOfType([PropTypes.number, PropTypes.instanceOf(null)]),
  activeButton: PropTypes.oneOf(["labels", "milestones", ""]),
};

export default LinkButtons;
