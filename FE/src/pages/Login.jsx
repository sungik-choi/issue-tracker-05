import React, { useEffect } from "react";
import PropTypes from "prop-types";
import { useHistory, useLocation } from "react-router-dom";

import LoginForm from "@Components/Login/LoginForm";

const Login = ({ isAuthenticated }) => {
  const history = useHistory();
  const location = useLocation();
  const { from } = location.state || { from: { pathname: "/" } };

  useEffect(() => {
    if (isAuthenticated) history.replace(from);
  }, []);

  return <LoginForm />;
};

Login.propTypes = {
  isAuthenticated: PropTypes.bool.isRequired,
};

export default Login;
