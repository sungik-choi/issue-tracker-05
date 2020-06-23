import React, { useContext } from "react";

import Navigation from "@Components/Labels/Navigation/Navigation";
import LabelTable from "@Components/Labels/LabelTable";

import { LabelListContext } from "@Contexts/labelListContext";
import { fetchSuccess, fetchError } from "@Reducers/labelListReducer";

import useFetch from "@Hooks/useFetch";
import { labelsUrl } from "@Utils/urls";

const Labels = () => {
  const { labelListDispatch } = useContext(LabelListContext);

  const loading = useFetch({
    url: labelsUrl,
    actionType: {
      successAction: fetchSuccess,
      errorAction: fetchError,
    },
    dispatch: labelListDispatch,
  });

  return (
    <>
      <Navigation />
      <LabelTable />
    </>
  );
};

export default Labels;
