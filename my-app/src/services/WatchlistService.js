// import { API_URL } from "../config/config.js";
const API_URL = "https://filmfolio-f39fe.uc.r.appspot.com/api";
// GET all watchlists for a user
export const getAllWatchlists = (userId, token) => {
  // console.log("WatchlistServie GET watchlists userId type: ", typeof userId);
  return fetch(
    `https://filmfolio-f39fe.uc.r.appspot.com/api/watchlists?userId=${userId}`,
    {
      headers: {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json",
      },
    }
  )
    .then((response) => {
      console.log(
        "WatchlistServie GET watchlists response.status: ",
        response.status
      );
      console.log("WatchlistServie GET watchlists response ", response);
      return response.json();
    })
    .then((data) => {
      console.log("WatchlistServie WatchlistServie GET data: ", data);
      return data.data;
    })
    .catch((error) => {
      console.log(error);
    });
};

// GET detailed info about a watchlist by name
// export const getOneWatchlist = async (userId, watchlistName, idToken) => {
//   const response = await fetch(`${API_URL}/watchlists/byName?userId=${userId}&name=${watchlistName}`, {
//     headers: {
//       'Authorization': `Bearer ${idToken}`
//     }
//   });

//   if (!response.ok) {
//     throw new Error(`Failed to fetch watchlist ${watchlistName}: ${response.statusText}`);
//   }

//   const watchlist = await response.json();
//   return watchlist;
// };

// export const getOneWatchlist = (userId, watchlistName, token) => {
//   console.log("GET one list userId: ", userId);
//   console.log("GET one list watchlistName: ", watchlistName);
//   // return fetch(`${API_URL}/watchlists/byName?userId=${userId}&name=${watchlistName}`, {
//   //     headers: {
//   //       Authorization: `Bearer ${token}`,
//   //     "Content-Type": "application/json",
//   //     },
//   //   }
//   // )
//   //   .then((response) => {
//   //     console.log("GET one list response: ", response);
//   //     // console.log("GET one list response: ", response.json().data);
//   //     return response.json();
//   //   })
//   //   .then((data) => {
//   //     console.log("GET one list watchlistName: ", watchlistName);
//   //     console.log("GET one list data: ", data);
//   //     return data.data;
//   //   })
//   //   .catch((error) => {
//   //     console.log(error);
//   //   });
//   return fetch(
//     `${API_URL}/watchlists/byName?userId=${userId}&name=${watchlistName}`,
//     {
//       headers: {
//         Authorization: `Bearer ${token}`,
//         "Content-Type": "application/json",
//       },
//     }
//   )
//     // .then((response) => {
//     //   if (!response.ok) {
//     //     throw new Error(`HTTP error! status: ${response.status}`);
//     //   }
//     //   console.log("GET one list response: ", response);
//     //   return response.json();
//     // })
//     // .then((data) => {
//     //   console.log("GET one list watchlistName: ", watchlistName);
//     //   console.log("GET one list data: ", data);
//     //   return data.data;
//     // })
//     .then((response) => {
//       if (!response.ok) {
//         throw new Error(`HTTP error! status: ${response.status}`);
//       }
//       console.log("GET one list response: ", response);
//       return response.text(); // parse response as text
//     })
//     .then((data) => {
//       console.log("GET one list watchlistName: ", watchlistName);
//       console.log("GET one list data: ", data);
//       return JSON.parse(data.data); // convert text to JSON object
//     })
//     .catch((error) => {
//       console.log(error);
//     });
// };

// POST a watchlist
export const addWatchlist = (userId, watchlistName, token) => {
  return (
    fetch(
      `https://filmfolio-f39fe.uc.r.appspot.com/api/watchlists?userId=${userId}`,
      {
        method: "POST",
        headers: {
          Authorization: `Bearer ${token}`,
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          name: watchlistName,
        }),
      }
    )
      .then((response) => {
        console.log(
          "WatchlistServie POST watchlist response.status: ",
          response.status
        );
        console.log("POST watchlist response ", response);
        return response.json();
      })
      // .then((data) => {
      //   console.log("POST data: ", data);
      //   return data.data;
      // })
      .catch((error) => {
        console.log(error);
      })
  );
};

// DELETE a watchlist
export const deleteWatchlist = (watchlistId, token) => {
  return fetch(
    `https://filmfolio-f39fe.uc.r.appspot.com/api/watchlists?watchlistId=${watchlistId}`,
    {
      method: "DELETE",
      headers: {
        Authorization: `Bearer ${token}`,
      },
    }
  )
    .then((response) => {
      console.log(
        "WatchlistServie DELETE watchlist response.status: ",
        response.status
      );
      console.log("DELETE watchlist response ", response);
      return response.json();
    })
    .catch((error) => {
      console.log(error);
    });
};

// PUT update watchlist name
export const updateListName = (watchlistId, newName, token) => {
  return fetch(
    `https://filmfolio-f39fe.uc.r.appspot.com/api/watchlists?watchlistId=${watchlistId}&name=${newName}`,
    {
      method: "PUT",
      headers: {
        Authorization: `Bearer ${token}`,
      },
    }
  )
    .then((response) => {
      console.log(
        "WatchlistServie PUT watchlist response.status: ",
        response.status
      );
      console.log("PUT watchlist response ", response);
      return response.json();
    })
    .catch((error) => {
      console.log(error);
    });
};
