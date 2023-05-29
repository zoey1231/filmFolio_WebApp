package com.example.movie.model;

import java.io.Serializable;
import java.util.Objects;

public class MovieInWatchlistId implements Serializable {
    private Long movieId;
    private Long watchlistId;

    public MovieInWatchlistId() {
    }

    public MovieInWatchlistId(Long movieId, Long watchlistId) {
        this.movieId = movieId;
        this.watchlistId = watchlistId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getWatchlistId() {
        return watchlistId;
    }

    public void setWatchlistId(Long watchlistId) {
        this.watchlistId = watchlistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieInWatchlistId that = (MovieInWatchlistId) o;
        return Objects.equals(movieId, that.movieId) && Objects.equals(watchlistId, that.watchlistId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, watchlistId);
    }

    @Override
    public String toString() {
        return "MovieInWatchlistId{" +
                "movieId=" + movieId +
                ", watchlistId=" + watchlistId +
                '}';
    }
}
