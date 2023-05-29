// import React, { useState, useEffect } from "react";
// import { firebase_auth } from "../firebaseConfig";

// function FirebaseAuth({ children }) {
//   const [isSignedIn, setIsSignedIn] = useState(false);
//   const [user, setUser] = useState(null);
//   const [idToken, setIdToken] = useState(null);

//   useEffect(() => {
//     const unregisterAuthObserver = firebase_auth.onAuthStateChanged((user) => {
//       // this gets called whenever a user signs in or out
//       setIsSignedIn(!!user);
//       setUser(user);
//       if (user) {
//         user.getIdToken().then(setIdToken);
//       } else {
//         setIdToken(null);
//       }
//     });
//     return () => unregisterAuthObserver(); // Make sure we un-register Firebase observers when the component unmounts.
//   }, []);

//   return (
//     <div>
//       {React.Children.map(children, (child) =>
//         React.cloneElement(child, { isSignedIn, user, idToken })
//       )}
//     </div>
//   );
// }

// export default FirebaseAuth;
