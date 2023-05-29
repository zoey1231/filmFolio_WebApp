import { createSlice } from "@reduxjs/toolkit";

const posterUrlsSlice = createSlice({
  name: "posterUrls",
  initialState: {},
  reducers: {
    updatePosterUrl(state, action) {
      const { id, posterUrl } = action.payload;
      state[id] = posterUrl;
    },
  },
});

export const { updatePosterUrl } = posterUrlsSlice.actions;

export const selectPosterUrl = (state, id) => state.posterUrls[id];

export default posterUrlsSlice.reducer;
