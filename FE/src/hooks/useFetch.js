import { useState, useEffect } from "react";

const useFetch = ({ url, actionType: { successAction, errorAction }, dispatch }) => {
  const [loading, setLoading] = useState(true);

  const getData = async () => {
    const data = await fetch(url);
    const { response } = await data.json();

    try {
      console.log("[log] fetch : ", response);
      dispatch(successAction(response));
    } catch (e) {
      dispatch(errorAction());
    }
    setLoading(false);
  };

  useEffect(() => {
    getData();
  }, []);

  return loading;
};

export default useFetch;
