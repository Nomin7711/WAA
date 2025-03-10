import React from 'react'

const PostDetails = (props) => {
    const post = props.post || {};
    
  return (
    <div className='postDetails'>
        <h2>{post.title}</h2>
        <h3>{post.author}</h3>
        <h5>This is the content of the post...</h5>
        <div style={{display : "flex", justifyContent : "center"}}>
            <button>edit</button>
            <button>delete</button>
        </div>
    </div>
  )
}
export default PostDetails;
