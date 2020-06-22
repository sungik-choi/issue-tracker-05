import React from "react";
import PropTypes from "prop-types";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";

import { issueType } from "@Types/issueType";

import Label from "@Components/common/Label";
import Title from "./Title";
import Details from "./Details";

const Contents = ({ id, data }) => {
  const classes = useStyles();
  const {
    title,
    attachedLabels,
    createdAt,
    milestone,
    author: { name },
  } = data;

  return (
    <>
      <Box display="flex" flexDirection="column" marginLeft={2}>
        <Box display="flex" alignItems="center">
          <Title title={title} />
          <Box className={classes.labels}>
            {attachedLabels &&
              attachedLabels.map(({ id, name, backgroundColor, color }) => (
                <Label key={id} name={name} backgroundColor={backgroundColor} color={color} />
              ))}
          </Box>
        </Box>
        <Details id={id} createdAt={createdAt} milestone={milestone} author={name} />
      </Box>
    </>
  );
};

const useStyles = makeStyles((theme) => ({
  labels: {
    "& > div + div": {
      marginLeft: theme.spacing(0.5),
    },
  },
}));

Contents.propTypes = {
  id: PropTypes.number.isRequired,
  data: issueType.isRequired,
};

export default Contents;
