import React, { useState, useCallback, useContext } from "react";

import { DetailedIssueContext } from "@Contexts/detailedIssueContext";
import { editTitleFetchOptions } from "@Reducers/detailedIssueReducer";

import InputBox from "./InputBox";
import TitleBox from "./TitleBox";
import editHandler from "@Components/DetailedIssue/editHandler";

import pipe from "@Utils/pipe";
import useFetch from "@Hooks/useFetch";

const Title = () => {
  const {
    detailedIssue: {
      issue: { id, title },
    },
    detailedIssueDispatch,
  } = useContext(DetailedIssueContext);

  console.log(title);

  // const [reFetchFunc, setReFetchFunc] = useState(null);

  const getReFetchFunc = (inputTitle) => {
    const { getData } = pipe(
      editTitleFetchOptions,
      useFetch,
    )({ detailedIssueDispatch, id, inputTitle });
    return getData;
  };

  const {
    isEdit,
    titleValue,
    inputTitle,
    onToggle,
    onChangeInput,
    onClickSave,
    onClickClose,
  } = editHandler(title);
  //context로 값 가져오기

  // const [isEdit, setIsEdit] = useState(false);
  // const [inputTitle, setinputTitle] = useState(issueTitle);
  // const [title, setTitle] = useState(issueTitle);

  // const onChangeInput = useCallback(({ target }) => {
  //   setinputTitle(target.value);
  // });

  // const onToggle = useCallback(() => {
  //   setIsEdit((prevState) => !prevState);
  // });

  // const onClickSave = useCallback(() => {
  //   onToggle();

  //   if (inputTitle) {
  //     setTitle(inputTitle);
  //     //fetch
  //   } else {
  //     setTitle(title);
  //     setinputTitle(title);
  //   }
  // });

  // const onClickClose = () => {
  //   setinputTitle(title);
  //   onToggle();
  // };

  return (
    <>
      {isEdit ? (
        <InputBox
          value={inputTitle}
          onChange={onChangeInput}
          onClickSave={onClickSave}
          onClickClose={onClickClose}
          getReFetchFunc={getReFetchFunc}
        />
      ) : (
        <TitleBox title={titleValue} id={id} onClickEdit={onToggle} />
      )}
    </>
  );
};

export default Title;
