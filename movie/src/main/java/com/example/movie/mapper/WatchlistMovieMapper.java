package com.example.movie.mapper;
import com.example.movie.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface WatchlistMovieMapper {
    /**
     * Find a watchlist by user id and watchlist name
     * @param userId the id of the user
     * @param watchlistName the name of the watchlist
     * @return the watchlist if found, null if not found
     */
    Watchlist findWatchlistByUserIdnName(@Param("userId") Long userId, @Param("name") String watchlistName);


    /**
     * Find a watchlist by id
     * @param watchlistId
     * @return the watchlist if found, null if not found
     */
    Watchlist findWatchlistById(Long watchlistId);

    /**
     * Insert a watchlist into the database
     * @param watchlist
     * @return the number of rows affected
     */
    Integer addWatchlist(Watchlist watchlist);


    /**
     * Update the name of a watchlist
     * @param watchlistId
     * @param name
     * @return the number of rows affected
     */
    Integer updateWatchlistName(@Param("watchlistId") Long watchlistId, @Param("name") String name);

    /**
     * Delete a watchlist
     * @param watchlistId
     * @return the number of rows affected
     */
    Integer deleteWatchlist(Long watchlistId);


    /**
     * Find all watchlists of a user
     * @param userId
     * @return a set of watchlists
     */
    Set<Watchlist> findWatchlistsByUserId(Long userId);

    /**
     * Count the number of watchlists of a user
     * @param userId
     * @return the number of watchlists
     */
    Integer countWatchlistsByUserId(Long userId);

    /**
     * Add a movie into a watchlist
     * @param movieInWatchlist
     * @return the number of rows affected
     */
    Integer addMovieToWatchlist(MovieInWatchlist movieInWatchlist);


    /**
     * Update a movie in a watchlist
     * @param movieInWatchlist
     * @return the number of rows affected
     */
    Integer updateMovieInWatchlist(MovieInWatchlist movieInWatchlist);

    /**
     * Delete a movie in a watchlist
     * @param movieInWatchlistId
     * @return the number of rows affected
     */
    Integer deleteMovieInWatchlist(MovieInWatchlistId movieInWatchlistId);

    /**
     * Find all watched movies in a watchlist
     * return both the information in the movie table and the information in the movie_in_watchlist table
     * @param watchlistId
     * @return a set of WatchedMovieDTO
     */
    Set<WatchedMovieDTO> findWatchedMoviesInWatchlist(Long watchlistId);

    /**
     * Find all unwatched movies in a watchlist
     * return only the information in the movie table
     * @param watchlistId
     * @return a set of Movie
     */
    Set<Movie> findUnwatchedMoviesInWatchlist(Long watchlistId);

    /**
     * Find all movies in a watchlist
     * return only the information in the movie table
     * @param watchlistId
     * @return a set of MovieInWatchlist
     */
    Set<MovieInWatchlist> findAllMoviesInWatchlist(Long watchlistId);

    /**
     * Count the number of movies in a watchlist
     * @param watchlistId
     * @return the number of movies in the watchlist
     */
    Integer countMoviesInWatchlist(Long watchlistId);

    /**
     * Count the number of watched movies in all watcheslists of a user
     * @param userId
     * @return the number of watched movies
     */
    Integer countWatchedMoviesByUserId(Long userId);
    /**
     * Count the number of unwatched movies in all watcheslists of a user
     * @param userId
     * @return the number of unwatched movies
     */
    Integer countUnwatchedMoviesByUserId(Long userId);
}
