import React from "react";
import { NavLink } from "react-router-dom";
const NavBar = (props) => {
  console.log("in NavBar");
  console.log("props", props);
  return (
    <nav className="navbar" style={{ paddingTop: "5px" }}>
      <div
        className="container"
        style={{ paddingLeft: "32px", paddingRight: "32px" }}
      >
        <div className="navbar-brand">
          <NavLink to="/" className="navbar-item navbar-text">
            {/* <figure className="image">
              <img
                className="is-rounded"
                src="https://bulma.io/images/placeholders/64x64.png"
                alt="Logo"
              />
            </figure> */}
            <span
              className="material-symbols-outlined"
              id="material-symbols-outlined-logo"
            >
              play_circle
            </span>
            <div className="subtitle has-text-white px-2">FilmFolio</div>
          </NavLink>

          <a
            role="button"
            className="navbar-burger"
            aria-label="menu"
            aria-expanded="false"
            data-target="navbarMenu"
          >
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
          </a>
        </div>
        {props.isSignedIn && (
          <div id="navbarMenu" className="navbar-menu navbar">
            <div className="navbar-end">
              <NavLink to="/alllist" className="navbar-item navbar-text">
                <div>My Lists</div>
              </NavLink>
              <NavLink to="/profile" className="navbar-item navbar-text">
                <i className="material-icons">person_outline</i>
                <div>{props.username}</div>
              </NavLink>
            </div>
          </div>
        )}
        {!props.isSignedIn && (
          <div id="navbarMenu" className="navbar-menu navbar">
            <div className="navbar-end">
              <div className="navbar-item">
                <a href="/profile" className="button is-primary">
                  Sign In
                </a>
              </div>
            </div>
          </div>
        )}
      </div>
    </nav>
  );
};

export default NavBar;
