import React from "react";

import Box from "@material-ui/core/Box";

import Label from "@Components/Labels";
import Title from "./Title";
import Details from "./Details";

const Contents = () => {
  return (
    <>
      <Box display="flex" flexDirection="column" marginLeft={2}>
        <Box display="flex" alignItems="center">
          <Title />
          <Label name="레이블 내용" backgroundColor="#000" color="#FFF" />
        </Box>
        <Details />
      </Box>
    </>
  );
};

export default Contents;
