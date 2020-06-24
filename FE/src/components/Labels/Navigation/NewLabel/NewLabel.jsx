import React from "react";
import PropTypes from "prop-types";
import pipe from "@Utils/pipe";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Paper from "@material-ui/core/Paper";
import Grid from "@material-ui/core/Grid";

import { setLabelColor, setLabelInfo } from "@Reducers/labelReducer";

import Label from "@Components/common/Label";
import InputField from "@Components/common/InputField";
import CustomButton from "@Components/common/CustomButton";
import ColorGenerateButton from "./ColorGenerateButton";

const LABEL_NAME = "Label name";
const DESCRIPTION = "Description";
const DEFAULT_LABEL_NAME = "Label Preview";
const CANCEL = "Cancel";
const CREATE_LABEL = "Create Label";

const NewLabel = ({
  state: { title, backgroundColor, color },
  dispatch,
  submitHandler,
  clickHandler,
}) => {
  const classes = useStyles();

  const changeTitleHandler = ({ target }) => dispatch(setLabelInfo({ title: target.value }));

  const changeDescriptionHandler = ({ target }) =>
    dispatch(setLabelInfo({ description: target.value }));

  const clickCreateButtonHandler = () => pipe(submitHandler, clickHandler)();

  return (
    <Box className={classes.container} component={Paper} variant="outlined" p={2} mb={2}>
      <Box mb={2}>
        <Label
          name={title || DEFAULT_LABEL_NAME}
          size="medium"
          backgroundColor={backgroundColor}
          color={color}
        />
      </Box>
      <Grid container component="form" justify="center" alignItems="center" spacing={3}>
        <Grid item xs={3}>
          <StyledInputField text={LABEL_NAME} required onChange={changeTitleHandler} />
        </Grid>
        <Grid item xs={4}>
          <StyledInputField text={DESCRIPTION} onChange={changeDescriptionHandler} />
        </Grid>
        <Grid item xs={2}>
          <ColorGenerateButton
            backgroundColor={backgroundColor}
            color={color}
            setLabelColor={() => dispatch(setLabelColor())}
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
            <CustomButton color="default" text={CANCEL} clickHandler={clickHandler} />
            <CustomButton
              disabled={!title}
              text={CREATE_LABEL}
              clickHandler={clickCreateButtonHandler}
            />
          </Box>
        </Grid>
      </Grid>
    </Box>
  );
};

// eslint-disable-next-line react/prop-types
const StyledInputField = ({ text, required, ...props }) => (
  <InputField
    required={required}
    label={text}
    placeholder={text}
    InputLabelProps={{
      shrink: true,
    }}
    size="small"
    {...props}
  />
);

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

NewLabel.propTypes = {
  state: PropTypes.shape({
    title: PropTypes.string.isRequired,
    backgroundColor: PropTypes.string.isRequired,
    color: PropTypes.string.isRequired,
  }).isRequired,
  dispatch: PropTypes.func.isRequired,
  submitHandler: PropTypes.func.isRequired,
  clickHandler: PropTypes.func.isRequired,
};

export default NewLabel;
