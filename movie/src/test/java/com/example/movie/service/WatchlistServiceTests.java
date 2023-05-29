package com.example.movie.service;

import com.example.movie.model.*;
import com.example.movie.service.ex.EmailDuplicatedException;
import com.example.movie.service.ex.EmailNotExistException;
import com.example.movie.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class) //runwith: indicate to start this unit test class, SpringRunner.class: an instance
public class WatchlistServiceTests {
    @Autowired
    private IWatchlistService watchlistService;

    @Test
    public void getAllWatchlistsForUser() {
        try {
            Set<Watchlist> watchlists = watchlistService.getAllWatchlistsForUser(3L);
            System.out.println(watchlists);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getWatchlistByName() {
        try {
            Watchlist watchlist = watchlistService.getWatchlistByName("My fav", 7L);
            System.out.println(watchlist);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getWatchlistByName_NotExist() {
        try {
            Watchlist watchlist = watchlistService.getWatchlistByName("Invalid", 7L);
            System.out.println(watchlist);
            assert watchlist == null;
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void addWatchlist() {
        try {
            Watchlist watchlist = new Watchlist();
            watchlist.setName("My Watchlist");
            watchlistService.addWatchlist(3L, watchlist);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deleteWatchlist() {
        try {
            watchlistService.deleteWatchlist(10L);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void updateWatchlist() {
        try {
            watchlistService.updateWatchlistName(2L, "80s movies");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void addMovieToWatchlist() {
        MovieInWatchlist movie = new MovieInWatchlist();

        movie.setWatched(false);
        movie.setId(new MovieInWatchlistId(829L,2L));
        try {
            watchlistService.addMovieToWatchlist(movie);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }
}
