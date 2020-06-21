import React from "react";

import Box from "@material-ui/core/Box";

const FlexBox = ({ children }) => {
  return (
    <Box display="flex" alignItems="center" justifyContent="space-between">
      {children}
    </Box>
  );
};

export default FlexBox;
