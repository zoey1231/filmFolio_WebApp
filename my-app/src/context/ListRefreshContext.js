import React, { createContext, useState } from "react";

export const ListRefreshContext = createContext();

export const ListRefreshProvider = ({ children }) => {
  const [refresh, setRefresh] = useState(false);

  const triggerRefresh = () => {
    setRefresh(!refresh);
  };

  return (
    <ListRefreshContext.Provider value={{ refresh, triggerRefresh }}>
      {children}
    </ListRefreshContext.Provider>
  );
};
