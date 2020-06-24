import React, { useState } from "react";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Paper from "@material-ui/core/Paper";
import Grid from "@material-ui/core/Grid";

import generateRandomColor from "@Utils/generateRandomColor";

import Label from "@Components/common/Label";
import InputField from "@Components/common/InputField";
import CustomButton from "@Components/common/CustomButton";

import ColorGenerateButton from "./ColorGenerateButton";

const LABEL_NAME = "Label name";
const DESCRIPTION = "Description";
const LABEL_PREVIEW = "Label Preview";
const CANCEL = "Cancel";
const CREATE_LABEL = "Create Label";

const NewLabel = ({ clickCancelButtonHandler, clickCreateButtonHandler }) => {
  const classes = useStyles();

  const [labelColor, setLabelColor] = useState(generateRandomColor());
  const { backgroundColor, color } = labelColor;

  const StyledInputField = ({ text, required }) => (
    <InputField
      required={required}
      label={text}
      placeholder={text}
      InputLabelProps={{
        shrink: true,
      }}
      size="small"
    />
  );

  return (
    <Box className={classes.container} component={Paper} variant="outlined" p={2} mb={2}>
      <Box mb={2}>
        <Label name={LABEL_PREVIEW} size="medium" backgroundColor={backgroundColor} color={color} />
      </Box>
      <Grid container component="form" justify="center" alignItems="center" spacing={3}>
        <Grid item xs={3}>
          <StyledInputField text={LABEL_NAME} required />
        </Grid>
        <Grid item xs={4}>
          <StyledInputField text={DESCRIPTION} />
        </Grid>
        <Grid item xs={2}>
          <ColorGenerateButton
            backgroundColor={backgroundColor}
            color={color}
            setLabelColor={() => setLabelColor(generateRandomColor())}
          />
        </Grid>
        <Grid item xs={3}>
          <Box
            className={classes.buttonWrap}
            display="flex"
            justifyContent="flex-end"
            alignItems="center"
            pt={1}
          >
            <CustomButton color="default" text={CANCEL} clickHandler={clickCancelButtonHandler} />
            <CustomButton text={CREATE_LABEL} clickHandler={clickCreateButtonHandler} />
          </Box>
        </Grid>
      </Grid>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  container: {
    flexGrow: 1,
    backgroundColor: theme.palette.grey[100],
    "& input": {
      backgroundColor: theme.palette.common.white,
    },
  },
  buttonWrap: {
    "& > button + button": {
      height: "100%",
      marginLeft: theme.spacing(1),
    },
  },
}));

export default NewLabel;
