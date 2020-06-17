import React from "react";
import PropTypes from "prop-types";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import AvatarGroup from "@material-ui/lab/AvatarGroup";

import CustomAvatar from "@Components/common/CustomAvatar";

const AvatarStack = ({ userData }) => {
  const classes = useStyles();
  const MAX_AVATAR_NUM = 4;

  return (
    <Box display="flex" alignItems="center">
      <AvatarGroup max={MAX_AVATAR_NUM} classes={{ avatar: classes.avatar }}>
        {userData.map(({ id, url }) => (
          <CustomAvatar key={id} id={id} url={url} />
        ))}
      </AvatarGroup>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  avatar: {
    fontSize: "1rem",
    borderColor: `${theme.palette.common.white}`,
  },
}));

AvatarStack.propTypes = {
  userData: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.string.isRequired,
      url: PropTypes.string.isRequired,
    }),
  ).isRequired,
};

export default AvatarStack;
