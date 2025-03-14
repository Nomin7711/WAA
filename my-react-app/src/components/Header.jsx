import React from "react";
import { Link } from "react-router";

const Header = () => {
  const isLoggedIn = localStorage.getItem("isLoggedIn");
  return (
    <header className="header">
      <div className="header-content">
        {isLoggedIn &&
            <div className="nav-links">
            <Link to="/posts">Posts</Link>
            <Link to="/newPost">New Post</Link>
          </div>
        }
        <div className="auth-links">
          <Link to="/login">Login</Link>
          {isLoggedIn && <h5>Hello {isLoggedIn}!</h5>}
        </div>
      </div>
    </header>
  );
};

export default Header;
