import React from "react";
import PropTypes from "prop-types";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Avatar from "@material-ui/core/Avatar";
import AvatarGroup from "@material-ui/lab/AvatarGroup";

const AvatarStack = ({ userData }) => {
  const classes = useStyles();
  const MAX_AVATAR_NUM = 4;

  return (
    <Box display="flex" alignItems="center">
      <AvatarGroup max={MAX_AVATAR_NUM} classes={{ avatar: classes.avatar }}>
        {userData.map(({ id, url }) => (
          <Avatar key={id} alt={id} src={url} />
        ))}
      </AvatarGroup>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  avatar: {
    width: theme.spacing(3),
    height: theme.spacing(3),
    fontSize: "1rem",
    border: `2px solid ${theme.palette.common.white}`,
  },
}));

AvatarStack.propTypes = {
  userData: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.string,
      url: PropTypes.string,
    }),
  ).isRequired,
};

export default AvatarStack;
