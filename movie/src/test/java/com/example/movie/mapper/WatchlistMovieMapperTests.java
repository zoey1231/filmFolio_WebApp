package com.example.movie.mapper;

import com.example.movie.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class) //runwith: indicate to start this unit test class, SpringRunner.class: an instance
public class WatchlistMovieMapperTests {
    @Autowired
    private WatchlistMovieMapper watchlistMovieMapper;

    @Autowired
    private UserMapper userMapper;
    /**
     *
     * Unit test
     * 1. must be void
     * 2. must has @Test annotation
     * has be public and has no input parameter
     */
    @Test
    public void addWatchlist() {

        User user = userMapper.findByEmail("test1@email.com");
        Watchlist watchlist = new Watchlist(user, "test");
        Integer res = watchlistMovieMapper.addWatchlist(watchlist);
        assert res == 1;
    }


    @Test
    public void findAllMoviesInWatchlist() {
        Long id = 1L;
        Set<MovieInWatchlist> movieInWatchlists = watchlistMovieMapper.findAllMoviesInWatchlist(id);
        System.out.println("find all movies in watchlist: \n" + movieInWatchlists);
    }
    @Test
    public void countMoviesInWatchlist() {
        Long id = 1L;
        Integer count = watchlistMovieMapper.countMoviesInWatchlist(id);
        System.out.println("count movies in watchlist: \n" + count);
    }

    @Test
    public void findWatchlistById() {
        Long id = 1L;
        Watchlist watchlist = watchlistMovieMapper.findWatchlistById(id);
        System.out.println("find watchlist by id: \n" + watchlist);
    }


    @Test
    public void findWatchlistsByUserId() {
        User user = userMapper.findByEmail("test1@email.com");
        Long userId = user.getId();
        Set<Watchlist> watchlists = watchlistMovieMapper.findWatchlistsByUserId(userId);
        System.out.println("find watchlists by user id: \n" + watchlists);
    }

    @Test
    public void findWatchlistsByUserId_nowatchlists() {
        User user = userMapper.findByEmail("test1@email.com");
        Long userId = user.getId();
        Set<Watchlist> watchlists = watchlistMovieMapper.findWatchlistsByUserId(userId);
        System.out.println("find watchlists by user id: \n" + watchlists);
    }

    @Test
    public void findWatchlistByuserIdAndWatchlistName(){
        Long userId = 7L;
        String name = "my fav";
        Watchlist watchlist = watchlistMovieMapper.findWatchlistByUserIdnName(userId, name);
        System.out.println("find watchlist by user id and watchlist name: \n" + watchlist);
    }
    @Test
    public void countWatchlistsByUserId() {
        User user = userMapper.findByEmail("test1@email.com");
        Long userId = user.getId();
        Integer count = watchlistMovieMapper.countWatchlistsByUserId(userId);
        System.out.println("count watchlists by user id: \n" + count);
    }

    @Test
    public void updateWatchlistName() {
        Long id = 1L;
        String name = "my watchlist";
        Integer rows = watchlistMovieMapper.updateWatchlistName(id, name);
        assert rows == 1;
        Watchlist watchlist = watchlistMovieMapper.findWatchlistById(id);
        System.out.println("find watchlist by id: \n" + watchlist);
        assert name.equals(watchlist.getName());
    }
    @Test
    public void deleteWatchlist() {
        Long id = 5L;
        Integer rows = watchlistMovieMapper.deleteWatchlist(id);
        assert rows == 1;
        Watchlist watchlist = watchlistMovieMapper.findWatchlistById(id);
        assert watchlist == null;
    }

    @Test
    public void addUnwatchedMovieToWatchlist() {
        MovieInWatchlistId movieInWatchlistId = new MovieInWatchlistId(832L, 1L);
        MovieInWatchlist movieInWatchlist = new MovieInWatchlist(movieInWatchlistId, false);
        Integer rows = watchlistMovieMapper.addMovieToWatchlist(movieInWatchlist);
        assert rows == 1;
    }
    @Test
    public void addWatchedMovieToWatchlist() {
        MovieInWatchlistId movieInWatchlistId = new MovieInWatchlistId(866L, 1L);
        MovieInWatchlist movieInWatchlist = new MovieInWatchlist(movieInWatchlistId, true,new Date(), 3.5F,"good, but not good enough");
        Integer rows = watchlistMovieMapper.addMovieToWatchlist(movieInWatchlist);
        assert rows == 1;
    }

    @Test
    public void updateWatchedMovieInWatchlist() {
        MovieInWatchlistId movieInWatchlistId = new MovieInWatchlistId(832L, 1L);
        MovieInWatchlist movieInWatchlist = new MovieInWatchlist(movieInWatchlistId, true);
        movieInWatchlist.setWatchedDate(new Date());
        movieInWatchlist.setRating(4.5F);
        Integer rows = watchlistMovieMapper.updateMovieInWatchlist(movieInWatchlist);
        assert rows == 1;
    }

    @Test
    public void deleteMovieInWatchlist() {
        MovieInWatchlistId movieInWatchlistId = new MovieInWatchlistId(832L, 1L);
        Integer rows = watchlistMovieMapper.deleteMovieInWatchlist(movieInWatchlistId);
        assert rows == 1;
    }

    @Test
    public void findWatchedMoviesInWatchlist() {
        Long id = 1L;
        Set<WatchedMovieDTO> watchedMovieDTOS = watchlistMovieMapper.findWatchedMoviesInWatchlist(id);
        System.out.println("find all watched movies in watchlist: \n" + watchedMovieDTOS);
    }
    @Test
    public void findWatchedMoviesInWatchlist_invalid() {
        Long id = -1L;
        Set<WatchedMovieDTO> watchedMovieDTOS = watchlistMovieMapper.findWatchedMoviesInWatchlist(id);
        System.out.println("find all watched movies in watchlist: \n" + watchedMovieDTOS);
    }
    @Test
    public void findUnwatchedMoviesInWatchlist() {
        Long id = 1L;
        Set<Movie> movieInWatchlists = watchlistMovieMapper.findUnwatchedMoviesInWatchlist(id);
        System.out.println("find all unwatched movies in watchlist: \n" + movieInWatchlists);
    }

}
