import { useState, useEffect } from "react";

const useFetch = ({
  url,
  dispatch,
  actionType: { successAction, errorAction },
  fetchOption = {},
}) => {
  const [loading, setLoading] = useState(true);
  const getData = async () => {
    const data = await fetch(url, fetchOption);
    const { response } = await data.json();

    try {
      console.log("[log] fetch : ", response);
      dispatch(successAction(response));
    } catch (e) {
      console.log("[log] error : ", response);
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
