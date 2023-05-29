package com.example.movie.service.impl;

import com.example.movie.mapper.MovieMapper;
import com.example.movie.model.Movie;
import com.example.movie.model.TmdbMovie;
import com.example.movie.service.ITmdbApiService;
import com.example.movie.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TmdbApiServiceImpl implements ITmdbApiService {
    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private MovieMapper movieMapper;
    private final String apiKey = "d03e8f7c7e930be01006898341d50589";
    private final String baseUrl = "https://api.themoviedb.org/3/";
    @Override
    public TmdbMovie getMovieById(Long tmdbId) {
        String url = baseUrl + "movie/" + tmdbId + "?api_key=" + apiKey;
        try {
            ResponseEntity<TmdbMovie> response = restTemplate.getForEntity(url, TmdbMovie.class);
            return response.getBody();
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public void addTmdbMovie(TmdbMovie tmdbMovie) {
        //check if tmdbMovie already exists in tmdb_movie table
        TmdbMovie tmdbMovieInDB = movieMapper.findTmdbMovieById(tmdbMovie.getId());
        if (tmdbMovieInDB != null) {
            return;
        }
        Integer rows = movieMapper.addTmdbMovie(tmdbMovie);
        if (rows != 1) {
            throw new InsertException("Failed to add tmdb movie");
        }
    }

    @Override
    public List<Movie> getPopularMovies(Integer limit) {
        List<TmdbMovie> tmdbMovies = movieMapper.findTopOrderByPopularityDesc(limit);
        List<Movie> movies = new ArrayList<>();

        for (TmdbMovie tmdbMovie : tmdbMovies) {
            Long tmdbId = tmdbMovie.getId();
            Movie movie = movieMapper.findByTmdbId(tmdbId);
            if (movie != null) {
                movies.add(movie);
            }
        }

        return movies;
    }
}
