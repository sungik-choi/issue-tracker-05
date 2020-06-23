import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Paper from "@material-ui/core/Paper";
import Grid from "@material-ui/core/Grid";
import CachedIcon from "@material-ui/icons/Cached";

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
      <Grid container justify="center" alignItems="center" spacing={3}>
        <Grid item xs={3}>
          <InputField
            label={LABEL_NAME}
            placeholder={LABEL_NAME}
            InputLabelProps={{
              shrink: true,
            }}
            size="small"
          />
        </Grid>
        <Grid item xs={4}>
          <InputField
            label={DESCRIPTION}
            placeholder={DESCRIPTION}
            InputLabelProps={{
              shrink: true,
            }}
            size="small"
          />
        </Grid>
        <Grid item xs={2}>
          <Box display="flex" justifyContent="center" alignItems="center">
            <CustomButton className={classes.iconButton} startIcon={<CachedIcon />} />
            <InputField
              label="Color"
              defaultValue="#FFFFFF"
              InputLabelProps={{
                shrink: true,
              }}
              size="small"
            />
          </Box>
        </Grid>
        <Grid item xs={3}>
          <Box
            className={classes.buttonWrap}
            display="flex"
            justifyContent="flex-end"
            alignItems="center"
            pt={1}
          >
            <CustomButton color="default" text="Cancel" clickHandler={null} />
            <CustomButton text="Create Label" clickHandler={null} />
          </Box>
        </Grid>
      </Grid>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  container: {
    flexGrow: 1,
    backgroundColor: theme.palette.grey[100],
    "& input": {
      backgroundColor: theme.palette.common.white,
    },
  },
  buttonWrap: {
    "& > button + button": {
      height: "100%",
      marginLeft: theme.spacing(1),
    },
  },
  iconButton: {
    padding: theme.spacing(1),
    marginRight: theme.spacing(1),
    marginTop: theme.spacing(1),
    minWidth: "40px",
    "& span": {
      margin: 0,
    },
  },
}));

export default NewLabel;
