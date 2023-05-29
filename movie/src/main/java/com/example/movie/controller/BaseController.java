package com.example.movie.controller;


import com.example.movie.service.ex.*;
import com.example.movie.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.filter.CorsFilter;


public class BaseController {

    public static final Integer SUCCESS = 200;

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> jsonResult = new JsonResult<>(e);
        if (e instanceof EmailDuplicatedException) {
            jsonResult.setState(4000);
            jsonResult.setMessage("Register failed: email already exists");
        } else if (e instanceof WatchlistCountLimitException) {
            jsonResult.setState(4001);
            jsonResult.setMessage("User watchlists exceeds limit: a user can only have 10 watchlists");
        } else if (e instanceof WatchlistNameDuplicatedException) {
            jsonResult.setState(4002);
            jsonResult.setMessage("Add/Edit watchlist failed: Watchlist name already exists");
        }else if (e instanceof UserIdNotExistException) {
            jsonResult.setState(4003);
            jsonResult.setMessage("User id does not exist");
        } else if(e instanceof WatchlistIdNotExistException) {
            jsonResult.setState(4004);
            jsonResult.setMessage("Watchlist does not exist");
        }else if(e instanceof MovieIdNotExistException) {
            jsonResult.setState(4005);
            jsonResult.setMessage("Movie does not exist");
        } else if (e instanceof MovieInWatchlistDuplicatedException) {
            jsonResult.setState(4006);
            jsonResult.setMessage("Add movie failed: movie already exists in the watchlist");
        }
        else if(e instanceof ParameterMissingException) {
            jsonResult.setState(5000);
            jsonResult.setMessage(e.getMessage());
        }
        else if (e instanceof InsertException) {
            jsonResult.setState(5001);
            jsonResult.setMessage(e.getMessage());
        } else if (e instanceof DeleteException) {
            jsonResult.setState(5002);
            jsonResult.setMessage(e.getMessage());
        } else if (e instanceof UpdateException) {
            jsonResult.setState(5003);
            jsonResult.setMessage(e.getMessage());
        }

        return jsonResult;
    }

}
