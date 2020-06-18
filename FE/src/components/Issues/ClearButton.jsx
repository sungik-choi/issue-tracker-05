import React from "react";

import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import CancelPresentationIcon from "@material-ui/icons/CancelPresentation";

const ClearButton = () => {
  if (null) return null; // 조건문에 상태값 넣기

  const CLEAR_BTN_TEXT = "Clear current search query, filters, and sorts";

  return (
    <Box component="div" mb={2}>
      <Button startIcon={<CancelPresentationIcon />}>{CLEAR_BTN_TEXT}</Button>
    </Box>
  );
};

export default ClearButton;
