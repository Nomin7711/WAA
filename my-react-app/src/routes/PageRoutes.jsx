import React from "react";
import { Routes, Route, Navigate } from "react-router";
import AddPost from "../components/AddPost";
import PostPage from "../components/PostPage";
import Login from "../components/Login";
import RequireAuth from "../components/RequireAuth";

const PageRoutes = () => {
  return (
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route element={<RequireAuth />}>
        <Route path="/" element={<PostPage />} />
        <Route path="/posts" element={<PostPage />} />
        <Route path="/newPost" element={<AddPost />} />
      </Route>
    </Routes>
  );
};
export default PageRoutes;
