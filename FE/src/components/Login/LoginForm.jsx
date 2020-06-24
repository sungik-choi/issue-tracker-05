import React from "react";

import { makeStyles } from "@material-ui/core/styles";
import Box from "@material-ui/core/Box";
import Paper from "@material-ui/core/Paper";
import Button from "@material-ui/core/Button";

import InputField from "@Components/common/InputField";
import CustomButton from "@Components/common/CustomButton";

const ID = "아이디";
const PASSWORD = "패스워드";
const LOGIN = "로그인";
const GITHUB_LOGIN = "Github 으로 로그인하기";
const SIGN_UP = "회원가입";

const LoginForm = () => {
  const classes = useStyles();

  return (
    <Box className={classes.wrap} display="flex" alignItems="center" justifyContent="center">
      <Box component={Paper} variant="outlined" width={400} p={5}>
        <form>
          <InputField label={ID} />
          <InputField
            label={PASSWORD}
            id="standard-password-input"
            type="password"
            autoComplete="current-password"
          />
          <Box className={classes.buttonWrap}>
            <Box display="flex" justifyContent="center">
              <Button>{SIGN_UP}</Button>
            </Box>
            <CustomButton color="default" className={classes.button} text={LOGIN} size="large" />
            <CustomButton className={classes.button} text={GITHUB_LOGIN} size="large" />
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
