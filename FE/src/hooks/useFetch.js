import { useState, useEffect } from "react";

const useFetch = ({
  url,
  deps = [],
  dispatch,
  actionType: { successAction, errorAction },
  option = {},
  skip = false,
}) => {
  const [loading, setLoading] = useState(true);
  const getData = async () => {
    const data = await fetch(url, option);
    const { response } = await data.json();

    try {
      console.log("[log] data : ", response);
      dispatch(successAction(response));
    } catch (e) {
      console.log("[log] error : ", response);
      dispatch(errorAction());
    }
    setLoading(false);
  };

  useEffect(() => {
    if (skip) return;
    getData();
    // eslint-disable-next-line
  }, deps);

  return { loading, getData };
};

export default useFetch;
