import { useEffect } from "react";

const useFetch = ({ url, actionType, dispatch }) => {
  const getData = async () => {
    const responseData = await fetch(url);
    const { response } = await responseData.json();

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
