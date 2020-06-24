import React, { useState, useCallback } from "react";

const editHandler = (initialValue) => {
  const [isEdit, setIsEdit] = useState(false);
  const [inputTitle, setinputTitle] = useState(initialValue);
  const [titleValue, setTitleValue] = useState(initialValue);

  const onChangeInput = useCallback(({ target }) => {
    setinputTitle(target.value);
  });

  const onToggle = useCallback(() => {
    setIsEdit((prevState) => !prevState);
  });

  const onClickSave = useCallback((fetchFunc) => {
    onToggle();

    if (inputTitle) {
      setTitleValue(inputTitle);
      fetchFunc();
    } else {
      setTitleValue(titleValue);
      setinputTitle(titleValue);
    }
  });

  const onClickClose = () => {
    setinputTitle(titleValue);
    onToggle();
  };

  return {
    isEdit,
    titleValue,
    inputTitle,
    onToggle,
    onChangeInput,
    onClickSave,
    onClickClose,
  };
};

export default editHandler;
