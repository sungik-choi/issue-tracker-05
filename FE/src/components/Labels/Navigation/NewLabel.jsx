import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Paper from "@material-ui/core/Paper";

import CustomButton from "@Components/common/CustomButton";
import Label from "@Components/common/Label";
import InputField from "@Components/common/InputField";

const NewLabel = () => {
  const classes = useStyles();
  const LABEL_NAME = "Label name";
  const DESCRIPTION = "Description";

  return (
    <Box className={classes.container} component={Paper} variant="outlined" p={2} mb={2}>
      <Box mb={2}>
        <Label name="default" size="medium" backgroundColor="black" color="white" />
      </Box>
      <Box className={classes.textField} display="flex">
        <InputField
          label={LABEL_NAME}
          placeholder={LABEL_NAME}
          InputLabelProps={{
            shrink: true,
          }}
          size="small"
        />
        <InputField
          label={DESCRIPTION}
          placeholder={DESCRIPTION}
          InputLabelProps={{
            shrink: true,
          }}
          size="small"
        />
        <Box>
          <InputField
            label="Color"
            defaultValue="#FFFFFF"
            InputLabelProps={{
              shrink: true,
            }}
            size="small"
          />
        </Box>
        <Box>
          <CustomButton text="Create Label" clickHandler={null} />
        </Box>
      </Box>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  container: {
    backgroundColor: theme.palette.grey[100],
  },
  textField: {
    "& > div + div": {
      marginLeft: theme.spacing(2),
    },
    "& input": {
      backgroundColor: theme.palette.common.white,
    },
  },
}));

export default NewLabel;
