import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { useLocation } from "react-router-dom";
import WatchedFilm from "../components/WatchedFilm";
import TowatchFilm from "../components/TowatchFilm";
import { getUnwatched, getWatched } from "../services/MovieService";
// import { getOneWatchlist } from "../services/WatchlistService";
import { WatchlistProvider } from "../context/WatchlistContext";

const WatchListPage = ({ user, isSignedIn, idToken }) => {
  const location = useLocation();
  const searchParams = new URLSearchParams(location.search);
  const watchlistName = searchParams.get("watchlistName");
  const watchlistId = searchParams.get("watchlistId");
  const [toWatchMovies, setToWatchMovies] = useState([]);
  const [watchedMovies, setWatchedMovies] = useState([]);
  const [activeTab, setActiveTab] = useState("toWatch");

  const loadWatchlists = () => {
    console.log("in loadWatchlists");
    console.log("WatchlistPage.js watchlistId type ", typeof watchlistId);

    if (watchlistId === null || watchlistId === undefined) {
      throw new Error("watchlistId is null or undefined.");
    } else {
      try {
        getUnwatched(watchlistId, idToken).then((response) => {
          console.log(
            "WatchlistPage.js fetched unwatched response status ",
            response.status
          );
          console.log(
            "WatchlistPage.js fetched unwatched response - ",
            response
          );
          setToWatchMovies(response);
          console.log("WatchlistPage.js fetched unwatched - ", toWatchMovies);
        });
        getWatched(watchlistId, idToken).then((response) => {
          console.log("WatchlistPage.js fetched watched response - ", response);
          setWatchedMovies(response);
          console.log("WatchlistPage.js fetched watched - ", watchedMovies);
        });
      } catch (error) {
        console.error(error);
      }
    }
  };

  useEffect(() => {
    console.log(
      "WatchlistPage useEffect being called: "
      // watchlistId,
      // watchlistName,
      // idToken
    );
    loadWatchlists();
  }, []);

  const handleTabClick = (tab) => {
    setActiveTab(tab);
  };

  return (
    // only show profile page if user is signed in and idToken exists and user exists
    isSignedIn && user && idToken ? (
      <WatchlistProvider value={loadWatchlists}>
        <div className="container">
          <div className=" subtitle py-4">
            <Link to="/alllist">&lt; Back to all lists</Link>
          </div>
          <h1 className="title my-4">My List - {watchlistName}: </h1>
          <div className="button is-pulled-right">
            <Link to="/">Search for more to add to my list</Link>
          </div>
          <div className="tabs">
            <ul>
              <li className={activeTab === "toWatch" ? "is-active" : ""}>
                <a onClick={() => handleTabClick("toWatch")}>To Watch</a>
              </li>
              <li className={activeTab === "watched" ? "is-active" : ""}>
                <a onClick={() => handleTabClick("watched")}>Watched</a>
              </li>
            </ul>
          </div>
          {activeTab === "toWatch" ? (
            <div className="columns is-multiline">
              {Object.values(toWatchMovies).map((movie) => (
                <div className="column is-one-fifth" key={movie.id}>
                  <TowatchFilm
                    user={user}
                    currentListId={watchlistId}
                    film={movie}
                    idToken={idToken}
                  />
                </div>
              ))}
            </div>
          ) : (
            <div className="columns is-multiline">
              {Object.values(watchedMovies).map((movie) => (
                <div className="column is-full my-4" key={movie.id}>
                  <WatchedFilm
                    user={user}
                    currentListId={watchlistId}
                    film={movie}
                    idToken={idToken}
                  />
                </div>
              ))}
            </div>
          )}
        </div>
      </WatchlistProvider>
    ) : (
      <section>
        <div className="container">
          <p>
            <strong>Watch List Page</strong>
          </p>
          <p>
            You must be <Link to="/signin">signed in</Link> to view this page.
          </p>
        </div>
      </section>
    )
  );
};

export default WatchListPage;
