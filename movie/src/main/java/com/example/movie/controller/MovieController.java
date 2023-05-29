package com.example.movie.controller;

import com.example.movie.model.*;
import com.example.movie.service.IMovieService;
import com.example.movie.service.ITmdbApiService;
import com.example.movie.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.CorsFilter;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/movies")
public class MovieController extends BaseController {

    @Autowired
    private IMovieService movieService;

    @Autowired
    private ITmdbApiService tmdbApiService;

    /*Watchlist related endpoints*/
    @GetMapping(path = "/search")
    public JsonResult<Set<Movie>> getSearchedMovies(@RequestParam("query") String searchString) {
        Set<Movie> movies = movieService.search(searchString);
        return new JsonResult<>(SUCCESS, movies);
    }

    @GetMapping(path = "/update-tmdb-movie-data")
    public JsonResult<Void> updateTmdbMovieData() {
        List<Movie> movies = movieService.getAllMovies();
        for (Movie movie : movies) {
            if (movie.getTmdbId() != null) {
                TmdbMovie tmdbMovie = tmdbApiService.getMovieById(movie.getTmdbId());
                if (tmdbMovie != null) {
                    //add tmdbMovie into tmdb_movie table
                    tmdbApiService.addTmdbMovie(tmdbMovie);
                }
            }
        }
        return new JsonResult<>(SUCCESS);
    }

    @GetMapping("/discover/popular")
    public JsonResult<List<Movie>> getPopularMovies(@RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<Movie> movies = tmdbApiService.getPopularMovies(limit);
        return new JsonResult<>(SUCCESS, movies);
    }
}
