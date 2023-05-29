import React, { useState, useEffect, useContext } from "react";
import { Link } from "react-router-dom";
import { getAllWatchlists } from "../services/WatchlistService";
import ListItem from "../components/ListItem";
import AddListModal from "../components/AddListModal";
import { ListRefreshContext } from "../context/ListRefreshContext";
const AllListPage = ({ user, isSignedIn, idToken }) => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [watchlists, setWatchlists] = useState([]);
  const { refresh, triggerRefresh } = useContext(ListRefreshContext);

  const refreshList = () => {
    console.log("refresh list");
    getAllWatchlists(user.id, idToken).then((data) => {
      setWatchlists(data);
    });
  };

  const handleCloseModal = () => {
    setIsModalOpen(false);
    console.log("close modal");
    // refreshList();
  };

  useEffect(() => {
    console.log("alllistpage use effect");
    refreshList();
  }, [isModalOpen, refresh]);

  const handleAddList = () => {
    if (watchlists.length >= 10) {
      alert("You can only have 10 lists at a time.");
    } else {
      console.log("add list");
      setIsModalOpen(true);
    }
  };

  return isSignedIn && user && idToken ? (
    <div>
      <h1 className="title mt-5">
        <strong>All of my watchlists:</strong>
      </h1>
      <div
        className="button is-pulled-right mr-5 is-outlined"
        style={{ borderColor: "#8c82fc" }}
        onClick={handleAddList}
      >
        Add a new list
      </div>
      <br />
      <br />
      <br />
      <div className="columns is-multiline">
        {Object.values(watchlists).map((list) => (
          <div className="column is-one-fifth" key={list.id}>
            <ListItem list={list} idToken={idToken} key={list.id} />
          </div>
        ))}
      </div>
      {isModalOpen && (
        <AddListModal
          user={user}
          idToken={idToken}
          onClose={() => handleCloseModal()}
        />
      )}
    </div>
  ) : (
    <section>
      <div className="container">
        <p>
          <strong>All List Page</strong>
        </p>
        <p>
          You must be <Link to="/signin">signed in</Link> to view this page.
        </p>
      </div>
    </section>
  );
};

export default AllListPage;
