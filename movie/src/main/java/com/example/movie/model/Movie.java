package com.example.movie.model;

import java.util.Objects;

public class Movie {
    private Long id;
    private String name;
    private Integer year;
    private String genre;
    private Long imdbId;
    private Long tmdbId;

    public Movie() {
    }

    public Movie(String name, Integer year, String genre, Long imdbId, Long tmdbId) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.imdbId = imdbId;
        this.tmdbId = tmdbId;
    }

    public Movie(Long id, String name, Integer year, String genre, Long imdbId, Long tmdbId) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.imdbId = imdbId;
        this.tmdbId = tmdbId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getImdbId() {
        return imdbId;
    }

    public void setImdbId(Long imdbId) {
        this.imdbId = imdbId;
    }

    public Long getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(Long tmdbId) {
        this.tmdbId = tmdbId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(year, movie.year) && Objects.equals(genre, movie.genre) && Objects.equals(imdbId, movie.imdbId) && Objects.equals(tmdbId, movie.tmdbId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, genre, imdbId, tmdbId);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", imdbId=" + imdbId +
                ", tmdbId=" + tmdbId +
                '}';
    }
}
