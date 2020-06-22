import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import AvatarGroup from "@material-ui/lab/AvatarGroup";

import { assigneeType } from "@Types/issueType";

import CustomAvatar from "@Components/common/CustomAvatar";

const AvatarStack = ({ allocatedAssignees }) => {
  const classes = useStyles();
  const MAX_AVATAR_NUM = 4;

  return (
    <Box display="flex" alignItems="center">
      <AvatarGroup max={MAX_AVATAR_NUM} classes={{ avatar: classes.avatar }}>
        {allocatedAssignees.map(({ id, name, avatarUrl }) => (
          <CustomAvatar key={id} userId={name} url={avatarUrl} tooltip />
        ))}
      </AvatarGroup>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  avatar: {
    fontSize: "1rem",
    width: theme.spacing(3),
    height: theme.spacing(3),
    borderColor: `${theme.palette.common.white}`,
  },
}));

AvatarStack.propTypes = {
  allocatedAssignees: assigneeType.isRequired,
};

export default AvatarStack;
