package com.example.movie.service.impl;

import com.example.movie.mapper.MovieMapper;
import com.example.movie.mapper.WatchlistMovieMapper;
import com.example.movie.mapper.UserMapper;
import com.example.movie.model.*;
import com.example.movie.service.IWatchlistService;
import com.example.movie.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
public class WatchlistServiceImpl implements IWatchlistService {
    @Value("${user.watchlist.max-count}")
    private Integer maxCount;
    @Autowired
    private WatchlistMovieMapper watchlistMovieMapper;
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public Set<Watchlist> getAllWatchlistsForUser(Long userId) {
        Set<Watchlist> watchlists = watchlistMovieMapper.findWatchlistsByUserId(userId);
        return watchlists;
    }

    @Override
    public Watchlist getWatchlistByName(String watchlistName, Long userId) {
        return watchlistMovieMapper.findWatchlistByUserIdnName(userId, watchlistName);
    }

    @Override
    public void addWatchlist(Long userId, Watchlist watchlist) {
        Integer count = watchlistMovieMapper.countWatchlistsByUserId(userId);
        if (count >= maxCount) {
            throw new WatchlistCountLimitException("A user can only have 10 watchlists");
        }
        if (userMapper.findById(userId) == null) {
            throw new UserIdNotExistException("User does not exist");
        }
        User user = new User();
        user.setId(userId);
        //check if the watchlist name already exists
        Watchlist result = watchlistMovieMapper.findWatchlistByUserIdnName(userId, watchlist.getName());
        if (result != null) {
            throw new WatchlistNameDuplicatedException("The watchlist name already exists");
        }
        watchlist.setUser(user);
        watchlist.setCreationDate(new Date());
        watchlist.setModificationDate(new Date());
        Integer rows = watchlistMovieMapper.addWatchlist(watchlist);
        if (rows != 1) {
            throw new InsertException("Insert watchlist failed");
        }
    }

    @Override
    public void deleteWatchlist(Long watchlistId) {
        Integer rows = watchlistMovieMapper.deleteWatchlist(watchlistId);
        if (rows != 1) {
            throw new DeleteException("Delete watchlist failed");
        }
    }

    @Override
    public void updateWatchlistName(Long watchlistId, String name) {
        Integer rows = watchlistMovieMapper.updateWatchlistName(watchlistId, name);
        if (rows != 1) {
            throw new UpdateException("Update watchlist name failed");
        }
    }

    @Override
    public Set<Movie> getAllUnwatchedMoviesInWatchlist(Long watchlistId) {
        return watchlistMovieMapper.findUnwatchedMoviesInWatchlist(watchlistId);
    }

    @Override
    public Set<WatchedMovieDTO> getAllWatchedMoviesInWatchlist(Long watchlistId) {
        return watchlistMovieMapper.findWatchedMoviesInWatchlist(watchlistId);
    }

    @Override
    public void addMovieToWatchlist(MovieInWatchlist movieInWatchlist) {
        Long watchlistId = movieInWatchlist.getId().getWatchlistId();
        Long movieId = movieInWatchlist.getId().getMovieId();

        //check if the watchlist exists
        Watchlist watchlist = watchlistMovieMapper.findWatchlistById(watchlistId);
        if (watchlist == null) {
            throw new WatchlistIdNotExistException("Watchlist does not exist");
        }
        //check if the movie exists
        Movie movie = movieMapper.findById(movieId);
        if (movie == null) {
            throw new MovieIdNotExistException("Movie does not exist");
        }
        //check if the movie is already in the watchlist
        Set<MovieInWatchlist> result = watchlistMovieMapper.findAllMoviesInWatchlist(watchlistId);
        System.out.println(result);
        // if  result contains MovieInWatchlist object that has same id as movieInWatchlist
        if (result.stream().anyMatch(m -> m.getId().equals(movieInWatchlist.getId()))) {
            throw new MovieInWatchlistDuplicatedException("Movie is already in the watchlist");
        }


        //add the movie to the watchlist
        Integer rows = watchlistMovieMapper.addMovieToWatchlist(movieInWatchlist);
        if (rows != 1) {
            throw new InsertException("Insert movie to watchlist failed");
        }

    }

    @Override
    public void updateMovieInWatchlist(MovieInWatchlist movieInWatchlist) {
        Integer rows = watchlistMovieMapper.updateMovieInWatchlist(movieInWatchlist);
        if (rows != 1) {
            throw new UpdateException("Update movie in watchlist failed");
        }
    }

    @Override
    public void deleteMovieFromWatchlist(MovieInWatchlistId movieInWatchlistId) {
        Integer rows = watchlistMovieMapper.deleteMovieInWatchlist(movieInWatchlistId);
        if (rows != 1) {
            throw new DeleteException("Delete movie from watchlist failed");
        }
    }

    @Override
    public Integer countWatchedMovies(Long userId) {
        Integer count = watchlistMovieMapper.countWatchedMoviesByUserId(userId);
        return count;
    }

    @Override
    public Integer countUnwatchedMovies(Long userId) {
        Integer count = watchlistMovieMapper.countUnwatchedMoviesByUserId(userId);
        return count;
    }

}
