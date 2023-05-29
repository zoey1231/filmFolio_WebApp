package com.example.movie.controller;

import com.example.movie.model.User;
import com.example.movie.service.IUserService;

import com.example.movie.service.IWatchlistService;
import com.example.movie.util.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.CorsFilter;


@RestController // == @Controller + @ResponseBody
@RequestMapping("/api/users")
public class UserController extends BaseController{
    @Autowired
    private final IUserService userService;

    @Autowired
    private IWatchlistService watchlistService;
    @Autowired
    public UserController (IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public JsonResult<Long> register(@RequestBody User user) {
        userService.register(user);
        return new JsonResult<Long>(SUCCESS, user.getId());
    }


    @GetMapping(path = "/byEmail")
    public JsonResult<User> getUserByEmail(@RequestParam("email") String email) {
        User user = userService.getUserByEmail(email);
        return new JsonResult<User>(SUCCESS, user);

    }

    @GetMapping(path = "/byId")
    public JsonResult<User> getUserById(@RequestParam("id") Long id) {
        User user = userService.getUserById(id);
        return new JsonResult<User>(SUCCESS, user);
    }

    @GetMapping(path = "/updateStatisticalData")
    public JsonResult<Void> updateStatisticalData(@RequestParam("id") Long id) {
        Integer unwatchedCounts = watchlistService.countWatchedMovies(id);
        Integer watchedCounts = watchlistService.countUnwatchedMovies(id);
        User user = userService.getUserById(id);
        user.setTotalWatchedCount(watchedCounts);
        user.setToWatchCount(unwatchedCounts);
        userService.updateUser(user);
        return new JsonResult<>(SUCCESS);
    }
    @GetMapping(path = "/test")
    public String test(Authentication authentication) {

        return "Hello, " + authentication.getName();
    }

    @GetMapping(path = "/login")
    public String login() {
        return "Welcome";
    }

    //    private final FirebaseApp firebaseApp;
//
//    @Autowired
//    public UserController(FirebaseApp firebaseApp) {
//        this.firebaseApp = firebaseApp;
//    }

//    @GetMapping("/test2")
//    public String getAllMovies(Authentication authentication) {
//
//        // Use the FirebaseApp object to authenticate the user
//        FirebaseAuthentication firebaseAuthentication = firebaseApp.auth().verifyIdToken(authentication.getPrincipal().toString());
//        FirebaseAuth.getInstance().verifyIdToken()
//        // Only authenticated users can access this endpoint
//        if (firebaseAuthentication == null) {
//            throw new UnauthorizedException("Authentication required");
//        }
//
//        // Retrieve all movies
//        List<Movie> movies = movieService.getAllMovies();
//
//        return movies;
//    }
}
