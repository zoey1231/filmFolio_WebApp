import firebase from "firebase/compat/app";
import "firebase/compat/auth";

import { firestoreDB } from "./firebaseConfig";

// CS5356 TO-DO #1
export const createPost = async (post) => {
  // Create a Post object with 3 properties: username, name, and message
  try {
    // Add a new document in collection "cities"
    await firestoreDB.collection("posts").add(post);
    console.log("Document successfully written", post);
  } catch (err) {
    console.error("Error writing document: ", err);
  }
};

// CS5356 TO-DO #2
export const getAllPosts = async () => {
  // Get all the posts in your collection
  // Each object should have an id, username, name, and message
  const allPosts = [];
  try {
    const querySnapshot = await firestoreDB.collection("posts").get();
    querySnapshot.forEach((doc) => {
      allPosts.push({
        id: doc.id,
        ...doc.data(),
      });
    });
  } catch (err) {
    console.error("Error getting document: ", err);
  }
  return allPosts;
};

// CS5356 TO-DO #3
export const deletePost = async (post) => {
  // Delete a post in your database
  try {
    await firestoreDB.collection("posts").doc(post.id).delete();
    console.log("Document successfully deleted");
  } catch (err) {
    console.error("Error removing document: ", err);
  }
};

// CS5356 TO-DO #4
export const likePost = async (post) => {
  // Update a particular post and increment the like counter
  try {
    var likes = firestoreDB.collection("posts").doc(post.id);
    await likes.update({
      likes: firebase.firestore.FieldValue.increment(1),
    });
    console.log("Document successfully updated");
  } catch (err) {
    console.error("Error updating document: ", err);
  }
};
