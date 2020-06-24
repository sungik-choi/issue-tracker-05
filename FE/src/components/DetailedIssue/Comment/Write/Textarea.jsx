import React from "react";
import TextareaAutosize from "@material-ui/core/TextareaAutosize";

import Button from "@material-ui/core/Button";

const TextArea = () => {
  return (
    <>
      <TextareaAutosize aria-label="Comment write" rowsMin={3} placeholder="Leave a comment" />
      <Button>ss</Button>
    </>
  );
};

export default TextArea;
