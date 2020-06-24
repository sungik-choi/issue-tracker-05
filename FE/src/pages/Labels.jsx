import React, { useContext } from "react";

import useFetch from "@Hooks/useFetch";

import Footer from "@Components/common/Footer";
import LoadingIndicator from "@Components/common/LoadingIndicator";
import Navigation from "@Components/Labels/Navigation/Navigation";
import LabelTable from "@Components/Labels/LabelTable";

import { LabelListContext } from "@Contexts/labelListContext";
import { getInitialData } from "@Reducers/labelListReducer";

const Labels = () => {
  const { labelListDispatch } = useContext(LabelListContext);
  const loading = useFetch(getInitialData(labelListDispatch));

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
