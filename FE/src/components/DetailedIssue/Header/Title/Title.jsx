import React, { useState, useCallback } from "react";

import InputBox from "./InputBox";
import TitleBox from "./TitleBox";
import Buttons from "./Buttons";
import { data } from "@Mock/detailedIssue";

import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";

const Title = () => {
  const EIDT_BTN_TEXT = "Edit";

  const issueTitle = data.issue.issueTitle;
  const issueId = data.issue.issueId;
  //context로 값 가져오기

  const [isEdit, setIsEdit] = useState(false);
  const [inputTitle, setinputTitle] = useState(issueTitle);
  const [title, setTitle] = useState(issueTitle);

  const onChangeInput = useCallback(({ target }) => {
    setinputTitle(target.value);
  });

  const onToggle = useCallback(() => {
    setIsEdit((prevState) => !prevState);
  });

  const onClickSave = useCallback(() => {
    setTitle(inputTitle);
    onToggle();
    //fetch
  });

  const onClickClose = () => {
    setinputTitle(title);
    onToggle();
  };

  return (
    <Box display="flex" alignItems="center" justifyContent="space-between">
      {isEdit ? (
        <InputBox
          title={inputTitle}
          id={issueId}
          onChange={onChangeInput}
          onClickSave={onClickSave}
          onClickClose={onClickClose}
        />
      ) : (
        <TitleBox title={title} onClickEdit={onToggle} />
      )}
    </Box>
  );
};

export default Title;
