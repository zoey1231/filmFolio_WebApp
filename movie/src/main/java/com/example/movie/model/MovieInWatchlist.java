package com.example.movie.model;

import java.util.Date;
import java.util.Objects;

public class MovieInWatchlist {
    private MovieInWatchlistId id;
    private Boolean watched;
    private Date watchedDate;
    private Float rating;
    private String comment;
    private Date modificationDate;

    public MovieInWatchlist() {
    }

    public MovieInWatchlist(MovieInWatchlistId id, boolean watched) {
        this.id = id;
        this.watched = watched;
        this.modificationDate = new Date();
    }
    public MovieInWatchlist(MovieInWatchlistId id, boolean watched, Date watchedDate, Float rating, String comment) {
        this.id = id;
        this.watched = watched;
        this.watchedDate = watchedDate;
        this.rating = rating;
        this.comment = comment;
        this.modificationDate = new Date();
    }
    public MovieInWatchlist(MovieInWatchlistId id, boolean watched, Date watchedDate, Float rating, String comment, Date modificationDate) {
        this.id = id;
        this.watched = watched;
        this.watchedDate = watchedDate;
        this.rating = rating;
        this.comment = comment;
        this.modificationDate = modificationDate;
    }

    public MovieInWatchlistId getId() {
        return id;
    }

    public void setId(MovieInWatchlistId id) {
        this.id = id;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public Date getWatchedDate() {
        return watchedDate;
    }

    public void setWatchedDate(Date watchedDate) {
        this.watchedDate = watchedDate;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieInWatchlist that = (MovieInWatchlist) o;
        return watched == that.watched && Float.compare(that.rating, rating) == 0 && Objects.equals(id, that.id) && Objects.equals(watchedDate, that.watchedDate) && Objects.equals(comment, that.comment) && Objects.equals(modificationDate, that.modificationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, watched, watchedDate, rating, comment, modificationDate);
    }

    @Override
    public String toString() {
        return "MovieInWatchlist{" +
                "id=" + id +
                ", watched=" + watched +
                ", watchedDate=" + watchedDate +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", modificationDate=" + modificationDate +
                '}';
    }
}
