package com.example.movie.model;


import java.util.Date;
import java.util.Objects;


public class User {
    private Long id;
    private String username;
    private String email;
    private String idToken;
    private Date joinedDate;
    private Integer toWatchCount;
    private Integer totalWatchedCount;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.joinedDate = new Date();
        this.toWatchCount = 0;
        this.totalWatchedCount = 0;
    }
    public User(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.joinedDate = new Date();
        this.toWatchCount = 0;
        this.totalWatchedCount = 0;
    }

    public User(Long id, String username, String email, String idToken, Date joinedDate, Integer toWatchCount, Integer totalWatchedCount) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.idToken = idToken;
        this.joinedDate = joinedDate;
        this.toWatchCount = toWatchCount;
        this.totalWatchedCount = totalWatchedCount;
    }
    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Integer getToWatchCount() {
        return toWatchCount;
    }

    public void setToWatchCount(Integer toWatchCount) {
        this.toWatchCount = toWatchCount;
    }

    public Integer getTotalWatchedCount() {
        return totalWatchedCount;
    }

    public void setTotalWatchedCount(Integer totalWatchedCount) {
        this.totalWatchedCount = totalWatchedCount;
    }

    //equals and hashcode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return toWatchCount == user.toWatchCount && totalWatchedCount == user.totalWatchedCount && Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(idToken, user.idToken) && Objects.equals(joinedDate, user.joinedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, idToken, joinedDate, toWatchCount, totalWatchedCount);
    }

    //toString()

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", idToken='" + idToken + '\'' +
                ", joinedDate=" + joinedDate +
                ", toWatchCount=" + toWatchCount +
                ", totalWatchedCount=" + totalWatchedCount +
                '}';
    }
}
