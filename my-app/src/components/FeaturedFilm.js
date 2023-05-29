import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getMovieInfo } from "../services/MovieService";
import { addMovie } from "../reducers/movieSlice";
import AddFilmModal from "./AddFilmModal";

const FeaturedFilm = ({ user, film, idToken }) => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [posterUrl, setPosterUrl] = useState("");
  const dispatch = useDispatch();
  const movies = useSelector((state) => state.movie);

  useEffect(() => {
    // console.log("FeaturedFilm useEffect");
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
    <div className="card" style={{ height: "700px" }}>
      <header className="card-header">
        <p className="card-header-title">{film.name}</p>
      </header>
      <div className="card-content" style={{ minHeight: "200px" }}>
        {posterUrl && (
          <div className="card-image">
            <figure className="image is-3by4">
              <img
                src={posterUrl}
                alt={film.name}
                style={{ objectFit: "contain", maxHeight: "100%" }}
              />
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
          className="button card-footer-item is-outlined mx-5"
          onClick={handleAddClick}
          style={{ borderColor: "#8c82fc" }}
        >
          Add to My List
        </div>
      </footer>
      {isModalOpen && (
        <AddFilmModal
          user={user}
          film={film}
          idToken={idToken}
          onClose={() => setIsModalOpen(false)}
        />
      )}
    </div>
  );
};

export default FeaturedFilm;
