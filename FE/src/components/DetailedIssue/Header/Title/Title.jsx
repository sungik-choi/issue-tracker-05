import React, { useState } from "react";

import InputBox from "./InputBox";
import TitleBox from "./TitleBox";

import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";

const Title = () => {
  const EIDT_BTN_TEXT = "Edit";

  const [isEdit, setIsEdit] = useState(false);

  const onClickEdit = () => {
    setIsEdit((prevState) => !prevState);
  };

  return (
    <Box display="flex" alignItems="center" justifyContent="space-between">
      {isEdit ? <InputBox /> : <TitleBox />}
      <Button variant="contained" onClick={onClickEdit}>
        {EIDT_BTN_TEXT}
      </Button>
    </Box>
  );
};

export default Title;
