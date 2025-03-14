import React from "react";
import Post from "./Post";

const Posts = (props) => {
  const posts = props?.data;
  return (
      <div className="posts">
        {posts &&
          posts.map((post) => (
            <Post
              key={post?.id}
              post={post}
              handlePostClick={props?.handlePostClick}
            />
          ))}
      </div>
  );
};
export default Posts;
