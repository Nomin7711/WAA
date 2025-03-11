import axios from 'axios';
import React, { useEffect, useState } from 'react'
import Comment from './Comment';

const PostDetails = (props) => {
    const post = props.post || {};
    const [postDetail, setPostDetail] = useState();
    useEffect(() => {
        if(post?.id) fetchDetails();
    }, [props.post])
    const fetchDetails = () => {
        axios.get(`http://localhost:8080/posts/${post?.id}`)
        .then((response) => {
            setPostDetail(response.data);
        })
        .catch((error) => {
            console.error('Error fetching post details:', error);
        });
    }
    const handleDelete =() =>{
        axios.delete(`http://localhost:8080/posts/${post?.id}`).then(() =>{
            props.fetchData();
            setPostDetail(null);
        }).catch((error) => {
            console.error('Error deleting post:', error);
        })
    }
    
  return (
    <div className='postDetails'>
        <h2>Title : {postDetail?.title}</h2>
        <h3>Author : {postDetail?.author}</h3>
        <h5>Content : {postDetail?.content}</h5>
        <div>
            {postDetail?.comments && postDetail?.comments.map((comment) => (
                <div key={comment.id}>
                    <Comment comment = {comment}/>
                </div>
            ))}
        </div>
        <div style={{display : "flex", justifyContent : "center"}}>
            <button >edit</button>
            <button onClick = {handleDelete}>delete</button>
        </div>
    </div>
  )
}
export default PostDetails;
