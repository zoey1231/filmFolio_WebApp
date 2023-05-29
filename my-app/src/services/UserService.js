// import { API_URL } from "../config/config.js";
const API_URL = "https://filmfolio-f39fe.uc.r.appspot.com/api";
//POST a user
export const addUser = (user, token) => {
  return fetch(`${API_URL}/users/register`, {
    method: "POST",
    headers: {
      Authorization: `Bearer ${token}`,
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      email: user.email,
      username: user.displayName,
    }),
  })
    .then((response) => {
      console.log("register response.status: ", response.status);
      console.log("register response ", response);
    })
    .catch((error) => {
      console.log(error);
    });
};

//Get a user's info
export const getUserInfo = (email, token) => {
  console.log("getUserInfo ", `${API_URL}/users/byEmail?email=${email}`);
  // email as a query parameter
  return fetch(`${API_URL}/users/byEmail?email=${email}`, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  })
    .then((response) => {
      console.log("response.status: ", response.status);
      return response.json();
    })
    .then((data) => {
      console.log("data: ", data);
      return data.data;
    })
    .catch((error) => {
      console.log(error);
    });
};

//update To-watch List Count and Total Movies Watched stats
export const updateStatisticalData = (userId, token) => {
  // email as a query parameter
  console.log("US userId: ", userId, "token: ", token);
  return fetch(
    `https://filmfolio-f39fe.uc.r.appspot.com/api/users/updateStatisticalData?id=${userId}`,
    {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    }
  )
    .then((response) => {
      console.log("response.status: ", response.status);
      return response.json();
    })
    .then((data) => {
      return data;
    })
    .catch((error) => {
      console.log(error);
    });
};
