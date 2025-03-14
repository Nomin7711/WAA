import React from 'react'
import Header from './Header';
import PageRoutes from '../routes/PageRoutes';

const Dashboard = () => {
 
  return (
    <div>
      <Header/>
      <PageRoutes/>
    </div>
  )
}
export default Dashboard;

   // const handleButton = () => {
    //     setPosts((prevPosts) => {
    //         const updatedPosts = [...prevPosts];
    //         updatedPosts[0] = {...updatedPosts[0], title: title };
    //         return updatedPosts;
    //       });
    //       if(selectedPost && selectedPost.id === 1) {
    //         setSelectedPost((prevPost) => ({
    //           ...prevPost,
    //           title: title,
    //         }));
    //       }
    // }