import React from "react";
import { Navigate, Outlet } from "react-router";

const RequireAuth = () => {
  const isLoggedIn = localStorage.getItem("isLoggedIn");

  if (!isLoggedIn) {
    return <Navigate to="/login" replace />;
}
  return <Outlet/>;
};

export default RequireAuth;
