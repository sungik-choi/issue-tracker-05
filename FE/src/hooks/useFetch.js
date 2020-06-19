import { useEffect } from "react";

const useFetch = ({ url, actionType, dispatch }) => {
  const getData = async () => {
    const data = await fetch(url);
    const { response } = await data.json();

    try {
      dispatch(actionType(response));
    } catch (e) {
      console.log(e);
    }
  };

  useEffect(() => {
    getData();
  }, []);
};

export default useFetch;
