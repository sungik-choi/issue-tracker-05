import React from "react";

import StatusIcon from "@Components/Common/StatusIcon";
import PrimaryButton from "@Components/Common/PrimaryButton";
import CheckCircleOutlineIcon from "@material-ui/icons/CheckCircleOutline";

const Info = () => {
  return (
    <div>
      <PrimaryButton text="Open" startIcon={<StatusIcon />} />
    </div>
  );
};

// const useStyles = makeStyles((theme) => ({
//   button: {
//     marginLeft: theme.spacing(6),
//     marginRight: theme.spacing(2),
//   },
// }));

export default Info;
