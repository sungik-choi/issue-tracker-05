import React from "react";
import PropTypes from "prop-types";

import Typography from "@material-ui/core/Typography";

const SelectedNumber = ({ selectedIssueSize }) => {
  const SELECTED_TEXT = "selected";

  return (
    <>
      {!!selectedIssueSize && (
        <Typography>
          {selectedIssueSize} {SELECTED_TEXT}
        </Typography>
      )}
    </>
  );
};

SelectedNumber.propTypes = {
  selectedIssueSize: PropTypes.number.isRequired,
};

export default SelectedNumber;
