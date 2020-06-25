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
    try {
      const data = await fetch(url, option);
      const { response } = await data.json();
      console.log("[log] data : ", response);
      dispatch(fetchSuccess(response));
    } catch (err) {
      console.log("[log] error : ", err);
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
