import React from "react";

import Box from "@material-ui/core/Box";

import Title from "./Title";
import Details from "./Details";
import Labels from "./Labels";

const Contents = () => {
  return (
    <>
      <Box display="flex" flexDirection="column" marginLeft={2}>
        <Box display="flex" alignItems="center">
          <Title />
          <Labels />
        </Box>
        <Details />
      </Box>
    </>
  );
};

export default Contents;
