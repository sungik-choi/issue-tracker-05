import React from "react";

import Box from "@material-ui/core/Box";

import PrimaryButton from "@Components/common/PrimaryButton";
import LinkButtons from "@Components/common/LinkButtons/LinkButtons";

const Navigation = () => {
  const NEW_LABEL_BTN_TEXT = "New Label";

  return (
    <Box
      component="nav"
      mt={14}
      mb={2}
      maxHeight={38}
      display="flex"
      justifyContent="space-between"
    >
      <LinkButtons activeButton="labels" />
      <PrimaryButton text={NEW_LABEL_BTN_TEXT} clickHandler={null} />
    </Box>
  );
};

export default Navigation;
