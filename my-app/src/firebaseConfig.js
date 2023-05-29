import firebase from "firebase/compat/app";
import "firebase/compat/auth";
import "firebase/compat/firestore";
import "firebase/compat/storage";

const firebaseConfig = {
  apiKey: "AIzaSyBImmv0wueu649Bpc6UZttdKyHtSpxBq8k",
  authDomain: "filmfolio-f39fe.firebaseapp.com",
  projectId: "filmfolio-f39fe",
  storageBucket: "filmfolio-f39fe.appspot.com",
  messagingSenderId: "143256278285",
  appId: "1:143256278285:web:ffc0f572f9b4475842cc44",
  measurementId: "G-4T0SSRYS11",
};

firebase.initializeApp(firebaseConfig);
export const firebase_auth = firebase.auth();
export const firestoreDB = firebase.firestore();
export const firebase_storage = firebase.storage();
export const firebaseObj = firebase;
