import React from "react";

const WatchlistContext = React.createContext();

export const WatchlistProvider = WatchlistContext.Provider;
export const WatchlistConsumer = WatchlistContext.Consumer;

export default WatchlistContext;
