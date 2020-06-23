import React, { useContext } from "react";

import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";

import CustomTable from "@Components/common/CustomTable";
import { LabelListContext } from "@Contexts/labelListContext";

const LabelTable = () => {
  const {
    labelList: { countOfLabel, labels },
    labelListDispatch,
  } = useContext(LabelListContext);

  const headContents = <Box fontWeight="800">8 Labels</Box>;
  const bodyContents = [
    {
      id: 1,
      contents: "1",
    },
    {
      id: 2,
      contents: "2",
    },
  ];

  return (
    <CustomTable ariaLabel="label-table" headContents={headContents} bodyContents={bodyContents} />
  );
};

export default LabelTable;
