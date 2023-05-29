import React, { useState, useEffect } from "react";
import moment from "moment";
import { updateStatisticalData, getUserInfo } from "../services/UserService";
import Avatar from "./Avatar";

const ProfileInfo = ({ user, idToken }) => {
  console.log(
    "in ProfileInfo.js, user: ",
    user,
    "idToken exists: ",
    idToken !== null
  );

  const [userInfo, setUserInfo] = useState(null);

  useEffect(() => {
    async function fetchData() {
      try {
        // Call updateStatisticalData first
        console.log("in ProfileInfo.js, calling updateStatisticalData", user.id, idToken);
        const res = await updateStatisticalData(user.id, idToken);
        if (res.state === 200) {
          // Then call getUserInfo
          const data = await getUserInfo(user.email, idToken);
          setUserInfo(data);
        }
      } catch (error) {
        console.error(error);
      }
    }

    if (user && idToken) {
      fetchData();
    }
  }, [user, idToken]);

  return (
    <div className="box">
      {userInfo ? (
        (console.log("in ProfileInfo.js, userInfo: ", userInfo),
        (
          <div className="columns is-vcentered">
            <div className="column is-one-quarter pl-6">
              <Avatar user={user} userId={userInfo?.id} />
            </div>
            <div className="column mx-6 px-3">
              <p>
                <strong>Username:</strong> {user.username}
              </p>
              <p>
                <strong>Joined On:</strong>
                {userInfo?.joinedDate
                  ? moment(userInfo?.joinedDate).format("MMMM Do YYYY")
                  : "N/A"}
              </p>
              <p>
                <strong>To-watch List Count:</strong> {userInfo?.toWatchCount}
              </p>
              <p>
                <strong>Total Movies Watched:</strong>{" "}
                {userInfo?.totalWatchedCount}
              </p>
            </div>
          </div>
        ))
      ) : (
        <div>
          <p>Loading user information...</p>
        </div>
      )}
    </div>
  );
};

export default ProfileInfo;
