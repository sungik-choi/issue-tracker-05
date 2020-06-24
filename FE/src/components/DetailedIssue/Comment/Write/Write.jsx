import React from "react";

import CustomTable from "@Components/common/CustomTable";

import Button from "@material-ui/core/Button";
import TextareaAutosize from "@material-ui/core/TextareaAutosize";
import { makeStyles } from "@material-ui/core/styles";
import TextArea from "./TextArea";
const Write = () => {
  const WRITE_BTN_TEXT = "write";

  const classes = useStyles();

  return (
    <>
      <CustomTable
        ariaLabel="issueTable"
        headContents={
          <Button variant="contained" className={classes.button} disableElevation>
            {WRITE_BTN_TEXT}
          </Button>
        }
        bodyContents={[{ id: 0, contents: <TextArea /> }]}
        className={classes.writeTable}
      />
    </>
  );
};

const useStyles = makeStyles(() => ({
  button: {
    backgroundColor: "#fff",
  },
  writeTable: {
    marginBottom: 40,
    "& th": {
      padding: "3px 20px",
      paddingBottom: 0,
      borderBottom: "none",
    },
    "& .MuiTableRow-hover": {
      pointerEvents: "none",
    },
  },
}));

export default Write;
