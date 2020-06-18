import React from "react";

import Box from "@material-ui/core/Box";

import PrimaryButton from "@Components/common/PrimaryButton";
import LinkButtons from "@Components/common/LinkButtons/LinkButtons";
import Filter from "./Filter/Filter";

const Navigation = () => {
  const NEW_ISSUE_BTN_TEXT = "New issue";

  return (
    <Box component="div" mt={6} mb={4} maxHeight={38} display="flex" justifyContent="space-between">
      <Filter />
      <LinkButtons />
      <PrimaryButton text={NEW_ISSUE_BTN_TEXT} clickHandler={null} />
    </Box>
  );
};

export default Navigation;
