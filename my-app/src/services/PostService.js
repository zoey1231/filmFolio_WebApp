// import { API_URL } from "../config/config.js";
const API_URL = "https://filmfolio-f39fe.uc.r.appspot.com/api";
// GET all posts
export const getAllPosts = (token) => {
  console.log("token: ", token);
  return fetch(`${API_URL}/posts`, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  })
    .then((response) => {
      console.log("response.status: ", response.status);
      return response.json();
    })
    .then((data) => {
      return data;
    })
    .catch((error) => {
      console.log("Error fetching posts: ", error);
    });
};

// POST a post
export const addPost = (post) => {
  return fetch(`${API_URL}/posts`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(post),
  })
    .then((response) => response.json())
    .then((data) => {
      return data;
    })
    .catch((error) => {
      console.log("Error adding post: ", error);
    });
};
