import React from "react";
import PropTypes from "prop-types";

import { makeStyles } from "@material-ui/core/styles";
import Avatar from "@material-ui/core/Avatar";
import Tooltip from "@material-ui/core/Tooltip";

const CustomAvatar = ({ id, url }) => {
  const classes = useStyles();

  return (
    <Tooltip title={id}>
      <Avatar alt={id} src={url} className={classes.avatar} />
    </Tooltip>
  );
};

const useStyles = makeStyles((theme) => ({
  avatar: {
    width: theme.spacing(3),
    height: theme.spacing(3),
  },
}));

CustomAvatar.propTypes = {
  id: PropTypes.string.isRequired,
  url: PropTypes.string.isRequired,
};

export default CustomAvatar;
