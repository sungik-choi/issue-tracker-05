import React from "react";
import PropTypes from "prop-types";

import { makeStyles } from "@material-ui/core/styles";
import Avatar from "@material-ui/core/Avatar";
import Tooltip from "@material-ui/core/Tooltip";
import CustomTable from "./CustomTable";

const CustomAvatar = ({ id, url, tooltip, ...props }) => {
  const classes = useStyles();

  return (
    <>
      {tooltip ? (
        <Tooltip title={id}>
          <Avatar alt={id} src={url} className={classes.avatar} {...props} />
        </Tooltip>
      ) : (
        <Avatar alt={id} src={url} className={classes.avatar} {...props} />
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
  tooltip: false,
};

CustomAvatar.propTypes = {
  id: PropTypes.string.isRequired,
  url: PropTypes.string.isRequired,
  tooltip: PropTypes.bool,
};

export default CustomAvatar;
