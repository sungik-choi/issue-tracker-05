import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";

import CustomButton from "@Components/common/CustomButton";

const CreateAndCancelButton = () => {
  const classes = useStyles();

  return (
    <Box
      className={classes.buttonWrap}
      display="flex"
      justifyContent="flex-end"
      alignItems="center"
      pt={1}
    >
      <CustomButton color="default" text="Cancel" clickHandler={null} />
      <CustomButton text="Create Label" clickHandler={null} />
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  buttonWrap: {
    "& > button + button": {
      height: "100%",
      marginLeft: theme.spacing(1),
    },
  },
}));

export default CreateAndCancelButton;
