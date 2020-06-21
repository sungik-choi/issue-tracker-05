import React from "react";
import PropTypes from "prop-types";

import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";

const TitleBox = ({ id, title, onClickEdit }) => {
  const EDIT_BTN = "edit";

  const classes = useStyles();

  return (
    <Box display="flex" alignItems="center" justifyContent="space-between" className={classes.wrap}>
      <Typography variant="h4" component="h2">
        <span>{title}</span>
        {id && <span className={classes.issueNum}>#{id}</span>}
      </Typography>
      <Button variant="contained" onClick={onClickEdit}>
        {EDIT_BTN}
      </Button>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  issueNum: {
    color: theme.palette.text.secondary,
    marginLeft: theme.spacing(2),
  },
  wrap: {
    height: 80,
  },
}));

TitleBox.defaultProps = {
  id: null,
};

TitleBox.propTypes = {
  id: PropTypes.number,
  title: PropTypes.string.isRequired,
  onClickEdit: PropTypes.func.isRequired,
};

export default TitleBox;
