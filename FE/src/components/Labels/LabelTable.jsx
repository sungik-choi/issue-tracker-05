import React, { useContext } from "react";

import Box from "@material-ui/core/Box";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";

import Label from "@Components/common/Label";
import CustomTable from "@Components/common/CustomTable";
import CustomButton from "@Components/common/CustomButton";

import { LabelListContext } from "@Contexts/labelListContext";

const LabelTable = () => {
  const {
    labelList: { countOfLabel, labels },
  } = useContext(LabelListContext);

  const headContents = <Box fontWeight="800">{countOfLabel} Labels</Box>;
  const bodyContents = labels.map(({ id, name, description, backgroundColor, color }) => ({
    id,
    contents: (
      <Grid container justify="center" alignItems="center">
        <Grid item xs={4}>
          <Label name={name} size="medium" backgroundColor={backgroundColor} color={color} />
        </Grid>
        <Grid item xs={6}>
          <Typography>{description}</Typography>
        </Grid>
        <Grid item xs={2}>
          <Box display="flex" justifyContent="flex-end" alignItems="center">
            <CustomButton variant="text" text="Edit" color="default" />
            <CustomButton variant="text" text="Delete" color="default" />
          </Box>
        </Grid>
      </Grid>
    ),
  }));

  return (
    <CustomTable ariaLabel="label-table" headContents={headContents} bodyContents={bodyContents} />
  );
};

export default LabelTable;
