package com.example.movie.service.impl;

import com.example.movie.mapper.MovieMapper;
import com.example.movie.model.Movie;
import com.example.movie.service.IMovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class MovieServiceImpl implements IMovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public Set<Movie> search(String searchString) {
        Set<Movie> movies = movieMapper.search(searchString);
        //return the first 50 results
        if (movies.size() > 50) {
            return movies.stream().limit(50).collect(java.util.stream.Collectors.toSet());
        }
        return movies;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieMapper.getAllMovies();
    }
}
