package com.example.movie.service;


import com.example.movie.model.Movie;
import com.example.movie.model.TmdbMovie;

import java.util.List;

public interface ITmdbApiService {
    TmdbMovie getMovieById(Long tmdbId);
    void addTmdbMovie(TmdbMovie tmdbMovie);

    List<Movie> getPopularMovies(Integer limit);
}
