import React, { useContext } from "react";

import useFetch from "@Hooks/useFetch";
import pipe from "@Utils/pipe";

import Footer from "@Components/common/Footer";
import LoadingIndicator from "@Components/common/LoadingIndicator";
import Navigation from "@Components/Labels/Navigation/Navigation";
import LabelTable from "@Components/Labels/LabelTable";

import { LabelListContext } from "@Contexts/labelListContext";
import { initDataFetchOptions } from "@Reducers/labelListReducer";

const Labels = () => {
  const { labelListDispatch } = useContext(LabelListContext);
  const { loading, getData } = pipe(initDataFetchOptions, useFetch)(labelListDispatch);

  return (
    <>
      {loading ? (
        <LoadingIndicator />
      ) : (
        <>
          <Navigation reFetch={getData} />
          <LabelTable reFetch={getData} />
          <Footer />
        </>
      )}
    </>
  );
};

export default Labels;
