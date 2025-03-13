import React, {useState} from 'react'
import Posts from './Posts'
import PostDetails from './PostDetails';
import axios from 'axios';
import AddPost from './AddPost';
import { PostContext } from '../context/PostContext';

const Dashboard = () => {
    const [posts, setPosts] = React.useState();
    const [title, setTitle] = useState('Happy Valentines Day');
    const [selectedPost, setSelectedPost] = useState(null);
    const handleTitle = (e) => {
        setTitle(e.target.value);
    }
 

    React.useEffect(() => {
        fetchData();
    }, []);

    
    const handleButton = () => {
        setPosts((prevPosts) => {
            const updatedPosts = [...prevPosts];
            updatedPosts[0] = {...updatedPosts[0], title: title };
            return updatedPosts;
          });
          if(selectedPost && selectedPost.id === 1) {
            setSelectedPost((prevPost) => ({
              ...prevPost,
              title: title,
            }));
          }
    }
   
    const handlePostClick = (post) => {
        setSelectedPost(post);
    };
    const fetchData = async () =>{
        const res = await axios.get('http://localhost:8080/posts');
        setPosts(res?.data);   
    }
 
  return (
    <PostContext.Provider value = {{selectedPost, setSelectedPost}}>
    <div>
        <Posts data = {posts} handlePostClick={handlePostClick}/>
        <input className = "input" type="text" placeholder='change title' onChange={handleTitle}/>
        <button style={{background : "rgb(106, 106, 245)", color : "white", marginLeft : "1em"}} onClick={handleButton}>Change name</button>
        <AddPost fetchData = {fetchData}/>
        <PostDetails fetchData = {fetchData}/>
    </div>
    </PostContext.Provider>
  )
}
export default Dashboard;