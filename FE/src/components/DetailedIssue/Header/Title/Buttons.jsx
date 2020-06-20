import React from "react";

import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";

const Buttons = ({ isEdit, onClick }) => {
  const SAVE_BTN = "save";
  const CLOSE_BTN = "close";
  const Edit_BTN = "edit";

  return (
    <div>
      {isEdit ? (
        <Box display="flex">
          <Button variant="contained" onClick={onClick}>
            {SAVE_BTN}
          </Button>
          <Button variant="contained" onClick={onClick}>
            {CLOSE_BTN}
          </Button>
        </Box>
      ) : (
        <Button variant="contained" onClick={onClick}>
          {Edit_BTN}
        </Button>
      )}
    </div>
  );
};

export default Buttons;
