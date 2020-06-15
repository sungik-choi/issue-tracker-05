import React, { useState } from "react";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Link from "@material-ui/core/Link";
import Typography from "@material-ui/core/Typography";
import Chip from "@material-ui/core/Chip";
import Avatar from "@material-ui/core/Avatar";
import AvatarGroup from "@material-ui/lab/AvatarGroup";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import Menu from "@material-ui/core/Menu";
import MenuItem from "@material-ui/core/MenuItem";
import ErrorOutlineIcon from "@material-ui/icons/ErrorOutline";

import CustomTable from "@Components/CustomTable/CustomTable";

const useStyles = makeStyles((theme) => ({
  small: {
    width: theme.spacing(3),
    height: theme.spacing(3),
  },
}));

const IssueTable = () => {
  const [anchorEl, setAnchorEl] = useState(null);

  const handleClick = (e) => setAnchorEl(e.currentTarget);
  const handleClose = () => setAnchorEl(null);

  const headContents = (
    <>
      <Checkbox />
      <Box>
        <Button aria-controls="simple-menu" aria-haspopup="true" onClick={handleClick}>
          Open Menu
        </Button>
        <Menu
          id="simple-menu"
          anchorEl={anchorEl}
          keepMounted
          open={!!anchorEl}
          onClose={handleClose}
        >
          <MenuItem onClick={handleClose}>Profile</MenuItem>
          <MenuItem onClick={handleClose}>My account</MenuItem>
          <MenuItem onClick={handleClose}>Logout</MenuItem>
        </Menu>
      </Box>
    </>
  );

  // ! <ErrorOutlineIcon color="primary" /> : 이슈 Close 여부에 따라 아이콘 변경 필요
  // ! <Link href="#" color="inherit"> : 해당 이슈로 가는 링크 지정 필요
  // ! <Chip label="FE" size="small" color="primary" />
  // ! label : 레이블 내용 ! color : 레이블 컬러 (별도의 스타일 지정 필요)

  const classes = useStyles();

  const bodyContents = [
    <>
      <Box display="flex" alignItems="center">
        <Checkbox />
        <ErrorOutlineIcon color="primary" />
        <Box display="flex" flexDirection="column" marginLeft={2}>
          <Box display="flex" flexWrap="wrap" alignItems="center">
            <Box marginRight={1}>
              <Typography variant="h6">
                <Link href="#" color="inherit">
                  [FE] 개발환경 구축하기
                </Link>
              </Typography>
            </Box>
            <Chip label="FE" size="small" color="primary" />
          </Box>
          <Box color="text.secondary">
            <Typography variant="body2">#18 opened 4 days ago by sungik-choi</Typography>
          </Box>
        </Box>
      </Box>
      <Box display="flex" alignItems="center">
        <AvatarGroup max={4}>
          <Avatar alt="" src="" className={classes.small} />
          <Avatar alt="" src="" className={classes.small} />
          <Avatar alt="" src="" className={classes.small} />
          <Avatar alt="" src="" className={classes.small} />
        </AvatarGroup>
      </Box>
    </>,
    <Typography>TEST 2</Typography>,
  ];

  return <CustomTable headContents={headContents} bodyContents={bodyContents} />;
};

export default IssueTable;
