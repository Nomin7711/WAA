import React from 'react'

const Post = (props) => {
    const post = props.post;
  return (
    <button className='post' onClick = {()=>props.handlePostClick(post)}>
        <h5>Id : {post?.id}</h5>
        <h5>Title : {post?.title}</h5>
        <h5>Author : {post?.author}</h5>
    </button>
  )
}
export default Post;
