import React from "react";

import Title from "./Title/Title";
import Info from "./Info/Info";

import Box from "@material-ui/core/Box";

const Header = () => {
  return (
    <Box my={5}>
      <Title />
      <Info />
    </Box>
  );
};

export default Header;
