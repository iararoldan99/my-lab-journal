import React from "react";
import { Link } from "react-router-dom";
import "../styles/Navbar.css";

const Navbar = () => {
  return (
    <>
      <nav className="navbar">
        <div className="navbar-container">
            <h1>My Lab Journal</h1>
          <ul className={"nav-menu"}>
          <li className="nav-item" onClick={() => window.location.reload()}>
              <Link to="/" className="nav-links">
                Home
              </Link>
            </li>
          </ul>
        </div>
      </nav>
      <hr />
    </>
  );
};

export default Navbar;
