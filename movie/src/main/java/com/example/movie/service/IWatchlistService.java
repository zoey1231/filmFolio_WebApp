package com.example.movie.service;

import com.example.movie.model.*;

import java.util.Set;

/**
 * Service interface for watchlist
 */
public interface IWatchlistService {
    /**
     * get all the watchlists of a user
     * @param userId
     * @return a set of watchlists
     */
    Set<Watchlist> getAllWatchlistsForUser(Long userId);

    /**
     * get watchlist by name
     * @param watchlistName the name of the watchlist
     * @param userId the id of the user
     * @return the watchlist if found, null if not found
     */
    Watchlist getWatchlistByName(String watchlistName, Long userId);

    /**
     * add a new watchlist for a user
     * @param watchlist
     * @param userId
     */
    void addWatchlist(Long userId, Watchlist watchlist);

    /**
     * delete a watchlist
     * @param watchlistId
     */
    void deleteWatchlist(Long watchlistId);

    /**
     * update the name of a watchlist
     * @param watchlistId
     * @param name
     *
     */
    void updateWatchlistName(Long watchlistId, String name);

    /**
     * get all unwatched movies in a watchlist
     * @param watchlistId
     * @return a set of movies
     */
    Set<Movie> getAllUnwatchedMoviesInWatchlist(Long watchlistId);

    /**
     * get all watched movies in a watchlist
     * @param watchlistId
     * @return a set of WatchedMovieDTO
     */
    Set<WatchedMovieDTO> getAllWatchedMoviesInWatchlist(Long watchlistId);

    /**
     * add a movie to a watchlist
     * @param movieInWatchlist
     * @return the id of the movie in watchlist
     */
    void addMovieToWatchlist(MovieInWatchlist movieInWatchlist);

    /**
     * update the information of a movie in a watchlist
     * @param movieInWatchlist
     *
     */
    void updateMovieInWatchlist(MovieInWatchlist movieInWatchlist);

    /**
     * delete a movie from a watchlist
     * @param movieInWatchlistId
     */
    void deleteMovieFromWatchlist(MovieInWatchlistId movieInWatchlistId);

    /**
     * Count the number of watched movies in all watchlists of a user
     * @param userId
     * @return the number of watched movies
     */
    Integer countWatchedMovies(Long userId);

    /**
     * Count the number of unwatched movies in all watchlists of a user
     * @param userId
     * @return the number of unwatched movies
     */
    Integer countUnwatchedMovies(Long userId);
}
