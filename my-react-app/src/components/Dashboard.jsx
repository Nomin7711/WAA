import React, {useState} from 'react'
import Posts from './Posts'
import PostDetails from './PostDetails';

const Dashboard = () => {
    const [posts, setPosts] = React.useState();
    const data = [
        {
            id: 1,
            title: "Happy Valentines Day",
            author: "Jane"
        },
        {
            id: 2,
            title: "Happy Birthday",
            author: "Jordan"
        },
        {
            id: 3,
            title: "Happy New Year",
            author: "Dave"
        }
    ];

    React.useEffect(() => {
        setPosts(data);
    }, []);

    const [title, setTitle] = useState('Happy Valentines Day');
    const handleTitle = (e) => {
        setTitle(e.target.value);
    }
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
    const [selectedPost, setSelectedPost] = useState(null);
    const handlePostClick = (post) => {
        setSelectedPost(post);
    };

  return (
    <div>
        <Posts data = {posts} handlePostClick={handlePostClick}/>
        <input type="text" placeholder='change title' onChange={handleTitle}/>
        <button className='btn' onClick={handleButton}>Change name</button>
        <PostDetails post = {selectedPost}/>
    </div>
  )
}
export default Dashboard;