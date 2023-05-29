package com.example.movie.model;

import java.util.Date;
import java.util.Objects;

public class WatchedMovieDTO {
    private Long id;
    private String name;
    private Integer year;
    private String genre;
    private Long imdbId;
    private Long tmdbId;
    private Date watchedDate;
    private float rating;
    private String comment;

    public WatchedMovieDTO() {
    }

    public WatchedMovieDTO(Long id, String name, Integer year, String genre, Long imdbId, Long tmdbId, Date watchedDate, float rating, String comment) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.imdbId = imdbId;
        this.tmdbId = tmdbId;
        this.watchedDate = watchedDate;
        this.rating = rating;
        this.comment = comment;
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

    public Date getWatchedDate() {
        return watchedDate;
    }

    public void setWatchedDate(Date watchedDate) {
        this.watchedDate = watchedDate;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WatchedMovieDTO that = (WatchedMovieDTO) o;
        return Float.compare(that.rating, rating) == 0 && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(year, that.year) && Objects.equals(genre, that.genre) && Objects.equals(imdbId, that.imdbId) && Objects.equals(tmdbId, that.tmdbId) && Objects.equals(watchedDate, that.watchedDate) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, genre, imdbId, tmdbId, watchedDate, rating, comment);
    }

    @Override
    public String toString() {
        return "WatchedMovieDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", imdbId=" + imdbId +
                ", tmdbId=" + tmdbId +
                ", watchedDate=" + watchedDate +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
