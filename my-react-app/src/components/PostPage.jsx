import React, { useState } from "react";
import Posts from "./Posts";
import axios from "axios";
import { PostContext } from "../context/PostContext";
import PostDetails from "./PostDetails";

const PostPage = () => {
  const [posts, setPosts] = useState();
  const [selectedPost, setSelectedPost] = useState(null);
  React.useEffect(() => {
    fetchData();
  }, []);
  const handlePostClick = (post) => {
    setSelectedPost(post);
  };
  const fetchData = async () => {
    const res = await axios.get("http://localhost:8080/posts");
    setPosts(res?.data);
  };
  return (
    <PostContext.Provider value={{ selectedPost, setSelectedPost }}>
      <div className="main-content">
        <Posts data={posts} handlePostClick={handlePostClick} />
        <PostDetails fetchData={fetchData} />
      </div>
    </PostContext.Provider>
  );
};

export default PostPage;
