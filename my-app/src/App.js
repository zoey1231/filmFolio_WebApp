import { StyledFirebaseAuth } from "react-firebaseui";
import { useState, useEffect } from "react";
import {
  BrowserRouter as Router,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";

import { firebaseObj, firebase_auth } from "./firebaseConfig";
import "./App.css";
import Navbar from "./components/Navbar";
import ProfilePage from "./pages/ProfilePage";
import Home from "./pages/Home";
import { addUser, getUserInfo } from "./services/UserService";
import WatchListPage from "./pages/WatchlistPage";
import AllListPage from "./pages/AllListPage";
const uiConfig = {
  signInFlow: "popup",
  signInOptions: [firebaseObj.auth.EmailAuthProvider.PROVIDER_ID],
  callbacks: {
    // Avoid redirects after sign-in.
    signInSuccessWithAuthResult: () => false,
  },
};

function App() {
  const [isSignedIn, setIsSignedIn] = useState(false);
  const [user, setUser] = useState(null);
  const [idToken, setIdToken] = useState(null);
  useEffect(() => {
    const unregisterAuthObserver = firebase_auth.onAuthStateChanged(
      async (firebaseUser) => {
        // this gets called whenever a user signs in or out
        setIsSignedIn(!!firebaseUser);
        // setUser(user); //TODO -> break it up to name, email, id(UserService getuserinfo)
        if (firebaseUser) {
          console.log("user signed in");
          // firebaseUser.getIdToken().then(setIdToken);
          const idToken = await firebaseUser.getIdToken();
          setIdToken(idToken);
          const { email } = firebaseUser;
          // getUserInfo(email, idToken).then((data) => {
          //   setUser(data);
          // });
          addUser(firebaseUser, idToken)
            .then(() => {
              return getUserInfo(email, idToken);
            })
            .then((data) => {
              setUser(data);
            })
            .catch((error) => {
              console.log(error);
            })
        } else {
          console.log("no user");
          setIdToken(null);
        }
      }
    );
    return () => unregisterAuthObserver(); // Make sure we un-register Firebase observers when the component unmounts.
  }, []);

  // get idToken and set it to state every 3600 seconds
  useEffect(() => {
    if (user) {
      const interval = setInterval(() => {
        user.getIdToken().then(setIdToken);
      }, 3600 * 1000);
      return () => clearInterval(interval);
    }
  }, [user]);

  // add user to database if idToken is not null and only execute once
  // useEffect(() => {
  //   if (isSignedIn && user && idToken) {
  //     addUser(user, idToken);
  //   }
  // }, [isSignedIn, user, idToken]);
  
  if (isSignedIn && user && idToken) {
    console.log(idToken);
  }
  if (!isSignedIn || !user || !idToken) {
    return (
      <div>
        <div
          className="container navbar"
          style={{ paddingLeft: "10px", paddingRight: "32px" }}
        >
          <div className="navbar-brand navbar-text pt-4">
            <span
              className="material-symbols-outlined"
              id="material-symbols-outlined-logo"
            >
              play_circle
            </span>
            <div className="subtitle has-text-white px-2">FilmFolio</div>
          </div>
        </div>

        <p className="subtitle px-6 mx-4 my-4">Please sign-in:</p>
        <StyledFirebaseAuth uiConfig={uiConfig} firebaseAuth={firebase_auth} />
      </div>
    );
  }
  return (
    <div style={{ marginLeft: "50px", marginTop: "50px" }}>
      {/* use Router to route the page to ProfilePage, HomePage */}
      <Router>
        <Navbar isSignedIn={isSignedIn} username={user?.username ?? null} />
        <Routes>
          <Route
            exact
            path="/"
            element={
              <Home isSignedIn={isSignedIn} idToken={idToken} user={user} />
            }
          />
          <Route
            path="/profile"
            element={
              <ProfilePage
                isSignedIn={isSignedIn}
                idToken={idToken}
                user={user}
              />
            }
          />
          <Route
            path="/alllist"
            element={
              <AllListPage
                isSignedIn={isSignedIn}
                idToken={idToken}
                user={user}
              />
            }
          />
          <Route
            path="/watchlists/:watchlistId"
            element={
              <WatchListPage
                user={user}
                isSignedIn={isSignedIn}
                idToken={idToken}
                // watchlistId={watchlist.id}
              />
            }
          />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
