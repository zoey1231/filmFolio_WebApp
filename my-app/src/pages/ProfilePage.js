import React from "react";
import { Link } from "react-router-dom";
import { firebase_auth } from "../firebaseConfig";
import ProfileInfo from "../components/ProfileInfo";

const ProfilePage = ({ user, isSignedIn, idToken }) => {
  return (
    // only show profile page if user is signed in and idToken exists and user exists
    isSignedIn && user && idToken ? (
      <>
        <section>
          <div className="container py-4">
            <p className="subtitle">
              <strong>Profile Page</strong>
            </p>
          </div>
        </section>
        <section>
          <div className="container">
            <ProfileInfo user={user} idToken={idToken} />
            <button
              className="button is-pulled-right is-outlined "
              onClick={() => firebase_auth.signOut()}
              style={{ borderColor: "#8c82fc" }}
            >
              Sign-out
            </button>
          </div>
        </section>
      </>
    ) : (
      <section>
        <div className="container">
          <p>
            <strong>Profile Page</strong>
          </p>
          <p>
            You must be <Link to="/signin">signed in</Link> to view this page.
          </p>
        </div>
      </section>
    )
  );
};

export default ProfilePage;
