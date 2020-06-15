import React from "react";

import Box from "@material-ui/core/Box";
import Link from "@material-ui/core/Link";
import Typography from "@material-ui/core/Typography";

// ! 해당 이슈로 가는 링크 지정 필요

const Title = () => {
  return (
    <Box marginRight={1}>
      <Typography variant="h6">
        <Link href="#" color="inherit">
          [FE] 개발환경 구축하기
        </Link>
      </Typography>
    </Box>
  );
};

export default Title;
