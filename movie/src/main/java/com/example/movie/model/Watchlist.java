package com.example.movie.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Watchlist {
    private Long id;
    private User user;
    private String name;
    private Date creationDate;
    private Date modificationDate;
    private Set<MovieInWatchlist> movies = new HashSet<>();

    public Watchlist() {
    }
    public Watchlist(User user, String name) {
        this.user = user;
        this.name = name;
        this.creationDate = new Date();
        this.modificationDate = new Date();
    }

    public Watchlist(User user, String name, Date creationDate, Date modificationDate, Set<MovieInWatchlist> movies) {
        this.user = user;
        this.name = name;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.movies = movies;
    }



    public Watchlist(Long id, User user, String name, Date creationDate, Date modificationDate, Set<MovieInWatchlist> movies) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Set<MovieInWatchlist> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieInWatchlist> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Watchlist watchlist = (Watchlist) o;
        return Objects.equals(id, watchlist.id) && Objects.equals(user, watchlist.user) && Objects.equals(name, watchlist.name) && Objects.equals(creationDate, watchlist.creationDate) && Objects.equals(modificationDate, watchlist.modificationDate) && Objects.equals(movies, watchlist.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, name, creationDate, modificationDate, movies);
    }

    @Override
    public String toString() {
        return "Watchlist{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", movies=" + movies +
                '}';
    }
}
