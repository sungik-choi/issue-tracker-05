import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import CachedIcon from "@material-ui/icons/Cached";

import CustomButton from "@Components/common/CustomButton";
import InputField from "@Components/common/InputField";

const ColorGenerateButton = () => {
  const classes = useStyles();

  return (
    <Box display="flex" justifyContent="center" alignItems="center">
      <CustomButton className={classes.iconButton} startIcon={<CachedIcon />} />
      <InputField
        label="Color"
        defaultValue="#FFFFFF"
        InputLabelProps={{
          shrink: true,
        }}
        size="small"
      />
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  iconButton: {
    padding: theme.spacing(1),
    marginRight: theme.spacing(1),
    marginTop: theme.spacing(1),
    minWidth: "40px",
    "& span": {
      margin: 0,
    },
  },
}));

export default ColorGenerateButton;
