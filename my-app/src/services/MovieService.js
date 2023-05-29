// import { API_URL } from "../config/config.js";
const API_URL = "https://filmfolio-f39fe.uc.r.appspot.com/api";

// Fetch movie's poster url along with other info from TMDB API
const tmdb_api_key = "d03e8f7c7e930be01006898341d50589";

export const getMovieInfo = (name, year, id, token) => {
  return fetch(
    `https://api.themoviedb.org/3/search/movie?api_key=${tmdb_api_key}&query=${name}&year=${year}`,
    {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    }
  )
    .then((response) => {
      console.log("Get movieInfo from TMDB API", name, year, id);
      console.log("response.status: ", response.status);
      return response.json();
    })
    .then((data) => {
      // if find a movie with the same id, save it to cache
      if (
        data.results.length > 0 &&
        data.results[0].id.toString() === id.toString()
      ) {
        return data.results[0];
      }
      return null;
    })
    .catch((error) => {
      console.log(error);
    });
};

// GET popular movies
export const getPopularMovies = (limit, token) => {
  return fetch(`${API_URL}/movies/discover/popular?limit=${limit}`, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  })
    .then((response) => {
      console.log("getPopularMovies response.status: ", response.status);
      return response.json();
    })
    .then((res) => {
      console.log("GET res: ", res);
      return res.data;
    })
    .catch((error) => {
      console.log(error);
    });
};

// GET movies by searchString
export const searchMovies = (searchString, token) => {
  return fetch(`${API_URL}/movies/search?query=${searchString}`, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  })
    .then((response) => {
      console.log("getPopularMovies response.status: ", response.status);
      return response.json();
    })
    .then((res) => {
      console.log("GET res: ", res);
      //return only the first 10 of the results
      return res.data.slice(0, 12);
      // return res.data;
    })
    .catch((error) => {
      console.log(error);
    });
};

export const getUnwatched = (watchlistId, token) => {
  console.log("MS GET watchlists idToken: ", token);
  console.log("MS GET watchlists watchlistId type: ", typeof watchlistId);
  console.log("MS GET watchlists watchlistId type: ", watchlistId);
  console.log(
    "MS GET watchlists URL: ",
    `${API_URL}/watchlists/${watchlistId}/movies/unwatched`
  );

  // Add a console.log statement before the fetch call
  console.log("Before fetch");
  return fetch(
    `https://filmfolio-f39fe.uc.r.appspot.com/api/watchlists/${watchlistId}/movies/unwatched`,
    {
      method: "GET",
      headers: {
        Accept: "*/*",
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
    }
  )
    .then((response) => {
      console.log("MovieService getUnwatched response.status: ", response);
      return response.json();
    })
    .then((data) => {
      console.log("MovieService getUnwatched data: ", data);
      return data.data;
    })
    .catch((error) => console.log(error))
    .finally(() => {
      // Add a console.log statement after the fetch call
      console.log("After fetch");
    });
};

export const getWatched = (watchlistId, token) => {
  return fetch(
    `https://filmfolio-f39fe.uc.r.appspot.com/api/watchlists/${watchlistId}/movies/watched`,
    {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    }
  )
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      return data.data;
    })
    .catch((error) => console.log(error));
};

export const addMovieToList = (
  watched,
  watchedDate,
  rating,
  comment,
  modificationDate,
  movieId,
  watchlistId,
  token
) => {
  // console.log("MS addMovie - ids: ", watchlistId, movieId);
  if (!watched) {
    watchedDate = null;
    rating = null;
    comment = null;
  }
  return fetch(
    `https://filmfolio-f39fe.uc.r.appspot.com/api/watchlists/${watchlistId}/movies?movieId=${movieId}`,
    {
      method: "POST",
      headers: {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        watched: watched,
        watchedDate: watchedDate,
        rating: rating,
        comment: comment,
        modificationDate: modificationDate,
      }),
    }
  )
    .then((response) => {
      console.log("addMovieToList response.status: ", response.status);
      return response.json();
    })
    .catch((error) => console.log(error));
};

export const updateMovie = (
  watched,
  watchedDate,
  rating,
  comment,
  modificationDate,
  movieId,
  oldListId,
  newListId,
  token
) => {
  console.log("MS updateMovie - ids: ", oldListId, movieId);
  return fetch(
    `https://filmfolio-f39fe.uc.r.appspot.com/api/watchlists/${oldListId}/movies?movieId=${movieId}`,
    {
      method: "PUT",
      headers: {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        watched: watched,
        watchedDate: watchedDate,
        rating: rating,
        comment: comment,
        modificationDate: modificationDate,
        id: {
          watchlistId: newListId,
        },
      }),
    }
  )
    .then((response) => {
      return response.json();
    })
    .catch((error) => console.log(error));
};

export const deleteMovie = (watchlistId, movieId, token) => {
  return fetch(
    `https://filmfolio-f39fe.uc.r.appspot.com/api/watchlists/${watchlistId}/movies?movieId=${movieId}`,
    {
      method: "DELETE",
      headers: {
        Authorization: `Bearer ${token}`,
      },
    }
  )
    .then((response) => {
      return response.json();
    })
    .catch((error) => console.log(error));
};
