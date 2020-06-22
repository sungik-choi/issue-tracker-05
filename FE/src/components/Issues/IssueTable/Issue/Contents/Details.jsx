import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import OutlinedFlagIcon from "@material-ui/icons/OutlinedFlag";


import calcTimeDiff from "@Utils/calcTimeDiff";

const Details = ({ id, createdAt, author, milestone }) => {
  const classes = useStyles();
  const text = `#${id} opened ${calcTimeDiff(createdAt)} ago by ${author}`;

  return (
    <Box color="text.secondary">
      <Typography variant="body2">
        {text}
        {milestone && (
          <>
            <OutlinedFlagIcon className={classes.icon} color="disabled" />
            {milestone.title}
          </>
        )}
      </Typography>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  icon: {
    width: theme.spacing(2),
    height: theme.spacing(2),
    marginLeft: theme.spacing(1),
  },
}));


export default Details;
