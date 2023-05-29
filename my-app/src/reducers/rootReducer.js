import { combineReducers } from "@reduxjs/toolkit";
import movieReducer from "./movieSlice";

const rootReducer = combineReducers({
  movie: movieReducer,
});

export default rootReducer;
