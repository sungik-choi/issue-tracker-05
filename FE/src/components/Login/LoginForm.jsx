import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Paper from "@material-ui/core/Paper";
import Button from "@material-ui/core/Button";

import InputField from "@Components/common/InputField";
import PrimaryButton from "@Components/common/PrimaryButton";

const LoginForm = () => {
  const classes = useStyles();

  return (
    <Box className={classes.wrap} display="flex" alignItems="center" justifyContent="center">
      <Box component={Paper} variant="outlined" width={400} p={5}>
        <form>
          <InputField label="아이디" />
          <InputField
            label="비밀번호"
            id="standard-password-input"
            type="password"
            autoComplete="current-password"
          />
          <Box className={classes.buttonWrap}>
            <Box display="flex" justifyContent="center">
              <Button>회원가입</Button>
            </Box>
            <PrimaryButton color="default" className={classes.button} text="로그인" size="large" />
            <PrimaryButton className={classes.button} text="Github 으로 로그인하기" size="large" />
          </Box>
        </form>
      </Box>
    </Box>
  );
};

const useStyles = makeStyles((theme) => ({
  wrap: {
    height: "100vh",
  },
  button: {
    width: "100%",
  },
  buttonWrap: {
    "& > button": {
      marginTop: theme.spacing(1.5),
    },
  },
}));

export default LoginForm;
