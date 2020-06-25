import React from "react";

import Picker from "./Picker";

import Box from "@material-ui/core/Box";
import { makeStyles } from "@material-ui/core/styles";

const Pickers = () => {
  const classes = useStyles();

  return (
    <Box>
      <Picker className={classes.picker} />
      <Picker className={classes.picker} />
      <Picker className={classes.picker} />
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  picker: {
    paddingBottom: "30px",
  },
}));

export default Pickers;
