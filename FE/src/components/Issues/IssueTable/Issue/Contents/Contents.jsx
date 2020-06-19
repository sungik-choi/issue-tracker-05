import React from "react";

import Box from "@material-ui/core/Box";

import Label from "@Components/common/Label";
import Title from "./Title";
import Details from "./Details";

const Contents = ({ id, title, attachedLabels, createdAt, author: { name } }) => {
  return (
    <>
      <Box display="flex" flexDirection="column" marginLeft={2}>
        <Box display="flex" alignItems="center">
          <Title title={title} />
          {attachedLabels &&
            attachedLabels.map(({ id, name, backgroundColor, color }) => (
              <Label key={id} name={name} backgroundColor={backgroundColor} color={color} />
            ))}
        </Box>
        <Details id={id} time={createdAt} author={name} />
      </Box>
    </>
  );
};

export default Contents;
