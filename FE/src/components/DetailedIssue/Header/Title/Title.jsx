import React, { useState, useCallback } from "react";

import InputBox from "./InputBox";
import TitleBox from "./TitleBox";
import { data } from "@Mock/detailedIssue";

const Title = () => {
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
    onToggle();

    if (inputTitle) {
      setTitle(inputTitle);
      //fetch
    } else {
      setTitle(title);
      setinputTitle(title);
    }
  });

  const onClickClose = () => {
    setinputTitle(title);
    onToggle();
  };

  return (
    <>
      {isEdit ? (
        <InputBox
          value={inputTitle}
          id={issueId}
          onChange={onChangeInput}
          onClickSave={onClickSave}
          onClickClose={onClickClose}
        />
      ) : (
        <TitleBox title={title} id={issueId} onClickEdit={onToggle} />
      )}
    </>
  );
};

export default Title;
