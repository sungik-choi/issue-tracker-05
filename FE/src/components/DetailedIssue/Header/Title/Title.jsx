import React, { useState } from "react";

import InputBox from "./InputBox";
import TitleBox from "./TitleBox";
import { data } from "@Mock/detailedIssue";

import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";

const Title = () => {
  const EIDT_BTN_TEXT = "Edit";

  const issueTitle = data.issue.issueTitle;
  const issueId = data.issue.issueId;

  const [isEdit, setIsEdit] = useState(false);
  const [title, setTitle] = useState(issueTitle);

  const onChangeInput = ({ target }) => {
    setTitle(target.value);
  };

  const onClickEdit = () => {
    setIsEdit((prevState) => !prevState);
  };

  return (
    <Box display="flex" alignItems="center" justifyContent="space-between">
      {isEdit ? <InputBox title={title} onChange={onChangeInput} /> : <TitleBox title={title} />}
      <Button variant="contained" onClick={onClickEdit}>
        {EIDT_BTN_TEXT}
      </Button>
    </Box>
  );
};

export default Title;
