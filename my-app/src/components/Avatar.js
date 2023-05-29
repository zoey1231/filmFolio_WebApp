import React from "react";

const Avatar = ({ user }) => {
  const initials =
    user && user.displayName
      ? user.displayName
          .split(" ")
          .map((name) => name[0])
          .join("")
      : "";

  return (
    <div>
      {user ? (
        <>
          {/* <img
              src={"https://bulma.io/images/placeholders/128x128.png"}
              alt="Profile"
            /> */}
          <span className="material-symbols-outlined pl-6">badge</span>
        </>
      ) : (
        <div className="is-flex is-justify-content-center is-align-items-center is-size-3 has-background-grey-lighter">
          {initials}
        </div>
      )}
    </div>
  );
};
export default Avatar;

// import { useState } from "react";
// import { firebase_storage } from "../firebaseConfig";

// function Avatar(props) {
//   const [avatarUrl, setAvatarUrl] = useState(null);
//   const [avatarFile, setAvatarFile] = useState(null);
//   console.log("in Avatar.js, props: ", props);
//   // Function to upload the avatar file to Firebase Storage
//   const handleAvatarUpload = async () => {
//     if (avatarFile) {
//       console.log("avatarFile: ", avatarFile);
//       var storageRef = firebase_storage.ref();

//       var avatarRef = storageRef.child(
//         `avatars/${props.userId}/${avatarFile.name}`
//       );
//       console.log(avatarRef);
//       await avatarRef.put(avatarFile);
//       console.log("Uploaded avatar file");
//       const url = await avatarRef.getDownloadURL();
//       setAvatarUrl(url);
//     }
//   };

//   // Function to handle the file input change event
//   const handleFileInputChange = (event) => {
//     //get the user selected file
//     const file = event.target.files[0];
//     setAvatarFile(file);
//   };

//   return (
//     <div>
//       {avatarUrl ? (
//         <img src={avatarUrl} alt="Avatar" />
//       ) : (
//         <div>No avatar found</div>
//       )}
//       <input type="file" onChange={handleFileInputChange} />
//       <button onClick={handleAvatarUpload}>Upload Avatar</button>
//     </div>
//   );
// }

// export default Avatar;
