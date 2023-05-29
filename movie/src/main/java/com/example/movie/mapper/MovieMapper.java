package com.example.movie.mapper;

import com.example.movie.model.Movie;
import com.example.movie.model.TmdbMovie;

import java.util.List;
import java.util.Set;

//mapper in mybatis is used to map the sql query to the java method
//this is the interface for the user mapper

public interface MovieMapper {
    /**
     * Insert movie data into the database
     *
     * @param movie
     * @return the number of rows affected(add/delete/update all have this return value)
     */
    Integer insert(Movie movie);

    /**
     * Find the movie by name
     * @param name
     * @return the movie data if found, null if not found
     */
    Movie findByName(String name);

    /**
     * Find the movie by id
     *
     * @param id
     * @return the movie data if found, null if not found
     */
    Movie findById(Long id);
    /**
     * Find the movie by tmdbId
     * @param tmdbId
     * @return the movie data if found, null if not found
     *
     */
    Movie findByTmdbId(Long tmdbId);

    /**
     * Update the movie data
     * @param movie
     * @return the number of rows affected
     */
    Integer update(Movie movie);

    /**
     * Search all fields of the movie data given a search string
     * @param searchString
     * @return a set of movie data
     */
    Set<Movie> search(String searchString);

    /**
     * Get all movies
     * @return a list of movie data
     */
    List<Movie> getAllMovies();

    /**
     * add a TmdbMovie into tmdb_movie table
     * @param tmdbMovie
     * @return the number of rows affected
     */
    Integer addTmdbMovie(TmdbMovie tmdbMovie);
    /**
     * find a TmdbMovie by id
     * @param id
     * @return the TmdbMovie if found, null if not found
     */
    TmdbMovie findTmdbMovieById(Long id);

    /**
     * find the top movies by popularity
     * @param limit
     * @return a list of TmdbMovie
     */
    List<TmdbMovie> findTopOrderByPopularityDesc(Integer limit);
}

