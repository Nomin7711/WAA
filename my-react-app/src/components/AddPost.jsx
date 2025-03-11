import axios from 'axios';
import React, {useState} from 'react'

const AddPost = (props) => {
    const [productState, setProductState] = useState({
        title: "",
        author: "",
        content:""
});
    const handleAdd = () => {
        axios.post(`http://localhost:8080/posts`, productState).then(() => {
            setProductState({
                title: "",
                author: "",
                content:""
            });
            props.fetchData();
        }).catch((err) => {
            console.log(err);
        });
    }
  return (
    <div>
        <h3>Add Post</h3>
        <input type="text" placeholder='Title' className = "input" value={productState.title} onChange={(e) => setProductState({...productState, title: e.target.value})}/>
        <input type="text" placeholder='Author' className = "input" value={productState.author} onChange={(e) => setProductState({...productState, author: e.target.value})}/>
        <input type="text" placeholder='Content' className = "input" value={productState.content} onChange={(e) => setProductState({...productState, content: e.target.value})}/>
        <button style={{background : "rgb(106, 106, 245)", color : "white"}} onClick={handleAdd}>Add</button>
    </div>
  )
}
export default AddPost;
