import React, { useEffect, useState, useContext } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getMovieInfo } from "../services/MovieService";
import { addMovie } from "../reducers/movieSlice";
import EditFilmModal from "./EditFilmModal";
import WatchlistContext from "../context/WatchlistContext";

const WatchedFilm = ({ user, currentListId, film, idToken }) => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [posterUrl, setPosterUrl] = useState("");
  const dispatch = useDispatch();
  const movies = useSelector((state) => state.movie);
  const loadWatchlists = useContext(WatchlistContext);

  useEffect(() => {
    console.log("WatchedFilm useEffect");
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
    <div className="columns">
      <div className="column">
        {posterUrl && (
          <div className="card-image">
            <figure className="image is-4by3" style={{ maxWidth: "250px" }}>
              <img src={posterUrl} alt={film.name} />
            </figure>
          </div>
        )}
      </div>
      <div className="column">
        <div className="card-content">
          <div className="content" style={{ overflowWrap: "break-word" }}>
            <p className="subtitle" style={{ color: "#8c82fc" }}>
              Movie Info
            </p>
            <p>
              <strong>Name: </strong> {film.name}
            </p>
            <p>
              <strong>Year: </strong> {film.year}
            </p>
            <p>
              <strong>Genre: </strong> {film.genre}
            </p>
            <div
              className="button is-outlined"
              onClick={handleAddClick}
              style={{ borderColor: "#8c82fc" }}
            >
              Edit
            </div>
          </div>
        </div>
      </div>
      <div className="column">
        <div className="card-content">
          <div className="content">
            <p className="subtitle" style={{ color: "#8c82fc" }}>
              My Rating and Comments
            </p>
            <p>
              <strong>Rating: </strong> {film.rating || "N/A"}
            </p>
            <p>
              <strong>Comment: </strong> {film.comment || "N/A"}
            </p>
            <p>
              <strong>Watched Date: </strong>{" "}
              {film.watchedDate
                ? new Date(film.watchedDate).toLocaleDateString()
                : "N/A"}
            </p>
          </div>
        </div>
      </div>
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

export default WatchedFilm;
