import React, { useContext } from "react";

import Footer from "@Components/common/Footer";
import LoadingIndicator from "@Components/common/LoadingIndicator";
import Navigation from "@Components/Labels/Navigation";
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
      {loading ? (
        <LoadingIndicator />
      ) : (
        <>
          <Navigation />
          <LabelTable />
          <Footer />
        </>
      )}
    </>
  );
};

export default Labels;
