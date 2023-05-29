import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import FeaturedFilm from "../components/FeaturedFilm";
import { getPopularMovies, searchMovies } from "../services/MovieService";
const Home = (props) => {
  // const navigate = useNavigate();
  const [featuredFilms, setFeaturedFilms] = useState([]);
  const [loading, setLoading] = useState(true);
  const [searchResults, setSearchResults] = useState([]);
  const [isSearchClicked, setIsSearchClicked] = useState(false);

  const handleSearch = async (event) => {
    event.preventDefault();
    const searchString = event.target.elements.search.value;
    try {
      const data = await searchMovies(searchString, props.idToken);
      setSearchResults(data);
      setIsSearchClicked(true);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    const fetchFeaturedFilms = async () => {
      try {
        const response = await getPopularMovies(8, props.idToken);
        console.log(response);
        setFeaturedFilms(response);
        setLoading(false);
      } catch (error) {
        console.log(error);
      }
    };

    fetchFeaturedFilms();
  }, [props.idToken]);

  return (
    <div>
      <section className="hero">
        <div className="hero-body">
          <div className="container is-flex is-justify-content-center">
            <form onSubmit={handleSearch}>
              <div className="field has-addons">
                <lable className="label mx-4 mt-2">Search Films:</lable>
                <div className="control">
                  <input
                    className="input"
                    type="text"
                    placeholder="Search for a film"
                    name="search"
                  />
                </div>
                <div className="control">
                  <button
                    className="button is-outlined"
                    style={{ borderColor: "#8c82fc" }}
                  >
                    Search
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </section>
      {/* add a separating line below the search component */}
      <hr className="has-background-grey-lighter mx-6 mt-6" />
      <section className="section">
        <div className="container">
          {isSearchClicked && searchResults.length > 0 && (
            <div className="search-results">
              <h2 className="title has-text-weight-bold">Searched Results</h2>
              <div className="columns is-multiline">
                {searchResults.map((film) => (
                  <div className="column is-one-third my-4" key={film.id}>
                    <FeaturedFilm
                      user={props.user}
                      film={film}
                      idToken={props.idToken}
                    />
                  </div>
                ))}
              </div>
            </div>
          )}
          {isSearchClicked && searchResults.length === 0 && (
            <div className="search-results">
              <h2 className="title has-text-weight-bold">Searched Results</h2>
              <p>
                No result matched your search. Please try again with a different
                search term.
              </p>
            </div>
          )}
        </div>
      </section>
      <section className="section">
        <div className="container featured-films">
          <h2 className="title has-text-weight-bold">Featured Films</h2>
          {loading ? (
            <div className="columns is-multiline">
              <div className="column is-one-third">
                <div className="box">
                  <span className="icon is-large">
                    <i className="fas fa-circle-notch fa-spin fa-3x"></i>
                  </span>
                </div>
              </div>
            </div>
          ) : (
            <div className="columns is-multiline">
              {featuredFilms.map((film) => (
                <div className="column is-one-third my-4" key={film.id}>
                  <FeaturedFilm
                    user={props.user}
                    film={film}
                    idToken={props.idToken}
                  />
                </div>
              ))}
            </div>
          )}
        </div>
      </section>
    </div>
  );
};
export default Home;
