import React from "react";
import PropTypes from "prop-types";

import { makeStyles } from "@material-ui/core/styles";
import Avatar from "@material-ui/core/Avatar";
import Tooltip from "@material-ui/core/Tooltip";

const CustomAvatar = ({ userId, url, tooltip, ...props }) => {
  const classes = useStyles();

  return (
    <>
      {tooltip ? (
        <Tooltip title={userId}>
          <Avatar alt={userId} src={url} className={classes.avatar} {...props} />
        </Tooltip>
      ) : (
        <Avatar alt={userId} src={url} className={classes.avatar} {...props} />
      )}
    </>
  );
};

const useStyles = makeStyles((theme) => ({
  avatar: {
    width: theme.spacing(3),
    height: theme.spacing(3),
  },
}));

CustomAvatar.defaultProps = {
  userId: "",
  tooltip: false,
};

CustomAvatar.propTypes = {
  userId: PropTypes.string,
  url: PropTypes.string.isRequired,
  tooltip: PropTypes.bool,
};

export default CustomAvatar;
