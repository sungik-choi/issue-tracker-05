import React, { useState, useCallback } from "react";

const editHandler = (initialValue) => {
  const [isEdit, setIsEdit] = useState(false);
  const [inputTitle, setinputTitle] = useState(initialValue);
  const [title, setTitle] = useState(initialValue);

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
      //fetch함수 인자로 받음
    } else {
      setTitle(title);
      setinputTitle(title);
    }
  });

  const onClickClose = () => {
    setinputTitle(title);
    onToggle();
  };

  return {
    isEdit,
    title,
    inputTitle,
    onToggle,
    onChangeInput,
    onClickSave,
    onClickClose,
  };
};

export default editHandler;
