package com.example.movie.service;

import com.example.movie.model.Movie;

import java.util.List;
import java.util.Set;

public interface IMovieService {
    /**
     * perform a fuzzy search on search string
     * @param searchString
     */
    Set<Movie> search(String searchString);

    List<Movie> getAllMovies();
}
