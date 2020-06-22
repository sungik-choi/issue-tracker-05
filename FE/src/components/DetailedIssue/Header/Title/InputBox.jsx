import React from "react";
import PropTypes from "prop-types";

import InputField from "@Components/Common/InputField";

import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";
import ButtonGroup from "@material-ui/core/ButtonGroup";
import { makeStyles } from "@material-ui/core/styles";

const InputBox = ({ value, onChange, onClickSave, onClickClose }) => {
  const SAVE_BTN_TEXT = "save";
  const CANCEL_BTN_TEXT = "Cancel";

  const classes = useStyles();

  const onSubmitForm = (e) => {
    e.preventDefault();
    onClickSave();
  };

  return (
    <form onSubmit={onSubmitForm}>
      <Box display="flex" alignItems="center" justifyContent="space-between">
        <InputField
          onChange={onChange}
          value={value}
          inputProps={{ "aria-label": "Issue title" }}
        />
        <ButtonGroup>
          <Button variant="contained" type="submit" value="submit" className={classes.button}>
            {SAVE_BTN_TEXT}
          </Button>
          <Button variant="contained" onClick={onClickClose}>
            {CANCEL_BTN_TEXT}
          </Button>
        </ButtonGroup>
      </Box>
    </form>
  );
};

const useStyles = makeStyles((theme) => ({
  button: {
    marginLeft: theme.spacing(6),
    marginRight: theme.spacing(2),
  },
}));

InputBox.defaultProps = {
  value: "",
  onChange: null,
};

InputBox.propTypes = {
  value: PropTypes.string,
  onChange: PropTypes.oneOfType([PropTypes.func, PropTypes.instanceOf(null)]),
  onClickSave: PropTypes.func.isRequired,
  onClickClose: PropTypes.func.isRequired,
};

export default InputBox;
