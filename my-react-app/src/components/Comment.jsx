import React from 'react'

const Comment = (props) => {
    const comment = props.comment || {};
  return (
    <div className='comment'>
        <h5>Id : {comment?.id}</h5>
        <h5>Name : {comment?.name}</h5>
    </div>
  )
}
export default Comment;
