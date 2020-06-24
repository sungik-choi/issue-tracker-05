import React from "react";
import PropTypes from "prop-types";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import CachedIcon from "@material-ui/icons/Cached";
import InputAdornment from "@material-ui/core/InputAdornment";

import CustomButton from "@Components/common/CustomButton";
import InputField from "@Components/common/InputField";

const ColorGenerateButton = ({ backgroundColor, color, setLabelColor }) => {
  const props = { backgroundColor, color };
  const classes = useStyles(props);

  const colorValueExceptSharp = (colorValue) => colorValue.substring(1);

  return (
    <Box display="flex" justifyContent="center" alignItems="center">
      <CustomButton
        className={classes.iconButton}
        startIcon={<CachedIcon />}
        onClick={setLabelColor}
      />
      <InputField
        className={classes.inputField}
        label="Color"
        value={colorValueExceptSharp(backgroundColor)}
        InputProps={{
          startAdornment: <InputAdornment position="start">#</InputAdornment>,
          readOnly: true,
        }}
        InputLabelProps={{
          shrink: true,
        }}
        size="small"
      />
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  iconButton: ({ backgroundColor, color }) => ({
    backgroundColor,
    color,
    padding: theme.spacing(1),
    marginRight: theme.spacing(1),
    marginTop: theme.spacing(1),
    minWidth: "40px",
    "& span": {
      margin: 0,
    },
    "&:hover": {
      backgroundColor,
      color,
    },
  }),
  inputField: {
    backgroundColor: theme.palette.common.white,
  },
}));

ColorGenerateButton.propTypes = {
  backgroundColor: PropTypes.string.isRequired,
  color: PropTypes.string.isRequired,
  setLabelColor: PropTypes.func.isRequired,
};

export default ColorGenerateButton;
