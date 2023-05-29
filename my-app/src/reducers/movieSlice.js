import { createSlice } from "@reduxjs/toolkit";

const movieSlice = createSlice({
  name: "movie",
  initialState: {},
  reducers: {
    addMovie: (state, action) => {
      state[action.payload.id] = action.payload;
    },
    removeMovie: (state, action) => {
      delete state[action.payload.id];
    },
  },
});

export const { addMovie, removeMovie } = movieSlice.actions;
export default movieSlice.reducer;
