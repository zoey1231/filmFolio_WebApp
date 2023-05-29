package com.example.movie.controller;

import com.example.movie.model.*;
import com.example.movie.service.IWatchlistService;
import com.example.movie.service.ex.ParameterMissingException;
import com.example.movie.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.CorsFilter;

import java.util.Set;

@RestController
//@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE },allowCredentials = "true")
@RequestMapping("/api/watchlists")
public class WatchlistController extends BaseController{

    @Autowired
    private IWatchlistService watchlistService;

    /*Watchlist related endpoints*/
    @GetMapping()
    public JsonResult<Set<Watchlist>> getWatchlistsForUser(@RequestParam("userId") Long userId) {
        Set<Watchlist> watchlists = watchlistService.getAllWatchlistsForUser(userId);
        return new JsonResult<>(SUCCESS, watchlists);
    }
    @GetMapping(path="/byName")
    public JsonResult<Watchlist> getWatchlistByName(@RequestParam("userId") Long userId, @RequestParam("name") String watchlistName) {
        Watchlist watchlist = watchlistService.getWatchlistByName(watchlistName, userId);
        return new JsonResult<>(SUCCESS, watchlist);
    }

    @PostMapping()
    public JsonResult<Long> addNewWatchlist(@RequestParam("userId") Long userId, @RequestBody Watchlist watchlist) {
        if (watchlist == null || watchlist.getName() == null || watchlist.getName().trim().isEmpty()) {
            throw new ParameterMissingException("Watchlist name cannot be empty");
        }
        watchlistService.addWatchlist(userId, watchlist);
        return new JsonResult<>(SUCCESS, watchlist.getId());

    }

    @DeleteMapping()
    public JsonResult<Void> deleteWatchlist(@RequestParam("watchlistId") Long watchlistId) {
        watchlistService.deleteWatchlist(watchlistId);
        return new JsonResult<>(SUCCESS);
    }

    @PutMapping()
    public JsonResult<Void> updateWatchlistName(@RequestParam("watchlistId") Long watchlistId, @RequestParam("name") String name) {
        watchlistService.updateWatchlistName(watchlistId, name);
        return new JsonResult<>(SUCCESS);
    }

    /*Movie in watchlist related endpoints*/

    @GetMapping(path="/{watchListId}/movies/unwatched")
    public JsonResult<Set<Movie>> getAllUnwatchedMoviesInWatchlist(@PathVariable("watchListId") Long watchlistId) {
        Set<Movie> movies = watchlistService.getAllUnwatchedMoviesInWatchlist(watchlistId);
        return new JsonResult<Set<Movie>>(SUCCESS, movies);
    }

    @GetMapping(path="/{watchListId}/movies/watched")
    public JsonResult<Set<WatchedMovieDTO>> getAllWatchedMoviesInWatchlist(@PathVariable("watchListId") Long watchlistId) {
        Set<WatchedMovieDTO> movies = watchlistService.getAllWatchedMoviesInWatchlist(watchlistId);
        return new JsonResult<Set<WatchedMovieDTO>>(SUCCESS, movies);
    }

    @PostMapping(path="/{watchListId}/movies")
    public JsonResult<Void> addMovieToWatchlist(@PathVariable("watchListId") Long watchlistId,@RequestParam("movieId") Long movieId, @RequestBody MovieInWatchlist movieInWatchlist) {
        if (movieInWatchlist == null || watchlistId == null || movieId == null) {
            throw new ParameterMissingException("watchlistId, movieId, and movie object cannot be empty");
        }
        movieInWatchlist.setId(new MovieInWatchlistId(movieId, watchlistId));
        watchlistService.addMovieToWatchlist(movieInWatchlist);
        return new JsonResult<>(SUCCESS);
    }

    @PutMapping(path="/{watchListId}/movies")
    public JsonResult<Void> updateMovieInWatchlist(@PathVariable("watchListId") Long watchlistId,@RequestParam("movieId") Long movieId, @RequestBody MovieInWatchlist movieInWatchlist) {
        if (movieInWatchlist == null || watchlistId == null || movieId == null) {
            throw new ParameterMissingException("watchlistId, movieId, and movie object cannot be empty");
        }
        Long newWatchlistId = movieInWatchlist.getId().getWatchlistId();
        if (newWatchlistId == null) {
            throw new ParameterMissingException("new watchlistId cannot be empty");
        }
        movieInWatchlist.setId(new MovieInWatchlistId(movieId, newWatchlistId));
//        watchlistService.updateMovieInWatchlist(movieInWatchlist);
        //delete from the old watchlist
        watchlistService.deleteMovieFromWatchlist(new MovieInWatchlistId(movieId, watchlistId));
        //add to the new watchlist
        watchlistService.addMovieToWatchlist(movieInWatchlist);
        return new JsonResult<>(SUCCESS);
    }

    @DeleteMapping(path="/{watchListId}/movies")
    public JsonResult<Void> deleteMovieFromWatchlist(@PathVariable("watchListId") Long watchlistId,@RequestParam("movieId") Long movieId) {
        watchlistService.deleteMovieFromWatchlist(new MovieInWatchlistId(movieId, watchlistId));
        return new JsonResult<>(SUCCESS);
    }

}
