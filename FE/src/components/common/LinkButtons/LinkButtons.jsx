import React from "react";
import PropTypes from "prop-types";

import ButtonGroup from "@material-ui/core/ButtonGroup";
import LocalOfferOutlinedIcon from "@material-ui/icons/LocalOfferOutlined";
import OutlinedFlagIcon from "@material-ui/icons/OutlinedFlag";

import LinkButton from "./LinkButton";

const LinkButtons = ({ labelCount, milestoneCount }) => {
  const LABELS = "Labels";
  const MILESTONES = "Milestones";

  return (
    <ButtonGroup variant="outlined">
      <LinkButton text={LABELS} icon={<LocalOfferOutlinedIcon />} count={labelCount} />
      <LinkButton text={MILESTONES} icon={<OutlinedFlagIcon />} count={milestoneCount} />
    </ButtonGroup>
  );
};

LinkButtons.defaultProps = {
  labelCount: null,
  milestoneCount: null,
};

LinkButtons.propTypes = {
  labelCount: PropTypes.oneOfType([PropTypes.number, PropTypes.instanceOf(null)]),
  milestoneCount: PropTypes.oneOfType([PropTypes.number, PropTypes.instanceOf(null)]),
};

export default LinkButtons;
