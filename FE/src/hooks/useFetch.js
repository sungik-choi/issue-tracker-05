import { useState, useEffect } from "react";

const useFetch = ({
  url,
  deps = [],
  dispatch,
  actionType: { fetchSuccess, fetchError },
  option = {},
  skip = false,
}) => {
  const [loading, setLoading] = useState(true);
  const getData = async () => {
    const data = await fetch(url, option);
    const { response } = await data.json();

    try {
      console.log("[log] data : ", response);
      dispatch(fetchSuccess(response));
    } catch (e) {
      console.log("[log] error : ", response);
      dispatch(fetchError());
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
