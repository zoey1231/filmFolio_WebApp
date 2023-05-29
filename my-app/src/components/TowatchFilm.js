import React, { useEffect, useState, useContext } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getMovieInfo } from "../services/MovieService";
import { addMovie } from "../reducers/movieSlice";
import EditFilmModal from "./EditFilmModal";
import WatchlistContext from "../context/WatchlistContext";

const TowatchFilm = ({ user, currentListId, film, idToken }) => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [posterUrl, setPosterUrl] = useState("");
  const dispatch = useDispatch();
  const movies = useSelector((state) => state.movie);
  const loadWatchlists = useContext(WatchlistContext);

  useEffect(() => {
    console.log("TowatchFilm useEffect");
    // Check if movie already exists in state
    if (movies && Object.keys(movies).length > 0 && movies[film.tmdbId]) {
      console.log("Movie already exists in redux movie store");
      setPosterUrl(
        `https://image.tmdb.org/t/p/w500${movies[film.tmdbId].poster_path}`
      );
    } else {
      // Call the API to get the movie info and poster URL
      getMovieInfo(film.name, film.year, film.tmdbId)
        .then((data) => {
          if (data && data.poster_path) {
            dispatch(addMovie(data));
            setPosterUrl(`https://image.tmdb.org/t/p/w500${data.poster_path}`);
          }
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }, [dispatch, film.tmdbId, film.name, film.year, movies]);

  const handleAddClick = () => {
    setIsModalOpen(true);
  };

  return (
    <div className="card" style={{ height: "500px" }}>
      <header className="card-header">
        <p className="card-header-title">{film.name}</p>
      </header>
      <div className="card-content">
        {posterUrl && (
          <div className="card-image">
            <figure className="image">
              <img src={posterUrl} alt={film.name} />
            </figure>
          </div>
        )}
        <div
          className="content"
          style={{ display: "block", overflowWrap: "break-word" }}
        >
          <p>
            <strong>Year: </strong> {film.year}
          </p>
          <p>
            <strong>Genre: </strong> {film.genre}
          </p>
          {/* <p>
            <strong>Spotify Link: </strong>
            <a href={film.spotifyLink}>{film.spotifyLink}</a>
          </p> */}
        </div>
      </div>
      <footer
        className="card-footer"
        style={{ position: "absolute", bottom: "0", width: "100%" }}
      >
        <div
          className=" button card-footer-item is-outlined mx-5"
          onClick={handleAddClick}
          style={{ borderColor: "#8c82fc" }}
        >
          Edit
        </div>
      </footer>
      {isModalOpen && (
        <EditFilmModal
          user={user}
          currentListId={currentListId}
          watchedTab={false}
          film={film}
          idToken={idToken}
          onClose={() => {
            setIsModalOpen(false);
            loadWatchlists();
          }}
        />
      )}
    </div>
  );
};

export default TowatchFilm;
