import { useEffect } from "react";

const useFetch = ({ url, actionType: { successAction, errorAction }, dispatch }) => {
  const getData = async () => {
    const data = await fetch(url);
    const { response } = await data.json();

    try {
      dispatch(successAction(response));
    } catch (e) {
      dispatch(errorAction());
    }
  };

  useEffect(() => {
    getData();
  }, []);
};

export default useFetch;
