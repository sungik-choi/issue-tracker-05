import React, { useContext } from "react";
import { useCookies } from "react-cookie";
import useFetch from "@Hooks/useFetch";
import pipe from "@Utils/pipe";

import Footer from "@Components/common/Footer";
import LoadingIndicator from "@Components/common/LoadingIndicator";
import Navigation from "@Components/Labels/Navigation/Navigation";
import LabelTable from "@Components/Labels/LabelTable";

import { LabelListContext } from "@Contexts/labelListContext";
import { initDataFetchOptions } from "@Reducers/labelListReducer";

import { TOKEN } from "@Constants/constants";

const Labels = () => {
  const [{ token }] = useCookies([TOKEN]);
  const { labelListDispatch } = useContext(LabelListContext);
  const { loading, getData } = pipe(
    initDataFetchOptions,
    useFetch,
  )({ dispatch: labelListDispatch, token });

  return (
    <>
      {loading ? (
        <LoadingIndicator />
      ) : (
        <>
          <Navigation reFetch={getData} />
          <LabelTable />
          <Footer />
        </>
      )}
    </>
  );
};

export default Labels;
