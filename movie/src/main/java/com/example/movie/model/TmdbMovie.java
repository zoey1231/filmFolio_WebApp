package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TmdbMovie {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("popularity")
    private Double popularity;

    public TmdbMovie() {
    }

    public TmdbMovie(Long id, Double popularity) {
        this.id = id;
        this.popularity = popularity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TmdbMovie tmdbMovie = (TmdbMovie) o;
        return Objects.equals(id, tmdbMovie.id) && Objects.equals(popularity, tmdbMovie.popularity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, popularity);
    }

    @Override
    public String toString() {
        return "TmdbMovie{" +
                "id=" + id +
                ", popularity=" + popularity +
                '}';
    }
}
