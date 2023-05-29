import React, { useState } from "react";
import { Link } from "react-router-dom";
import EditListModal from "./EditListModal";
// import { getOneWatchlist } from "../services/WatchlistService";

// This component represents a single list item in the AllListPage
const ListItem = ({ list, idToken }) => {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleEdit = () => {
    setIsModalOpen(true);
  };
  return (
    <div className="card list-card">
      <div className="list-name-wrapper card-content">
        {/* <Link to={`/watchlists`}>
          <div 
            className="button card-footer-item" 
            // style={{ width: '200px', height: '40px' }}
          >
            {list.name}
          </div>
        </Link> */}
        <div className="content">
          <Link
            to={`/watchlists/${list.id}?watchlistName=${list.name}&watchlistId=${list.id}`}
          >
            <div className="list-name ">{list.name}</div>
          </Link>
        </div>
      </div>
      <footer className="card-footer">
        <div
          className="button is-outlined card-footer-item mx-5"
          // style={{ width: '80px', height: '80px' }}
          onClick={handleEdit}
          style={{ borderColor: "#8c82fc" }}
        >
          edit
        </div>
      </footer>
      {isModalOpen && (
        <EditListModal
          list={list}
          idToken={idToken}
          onClose={() => setIsModalOpen(false)}
        />
      )}
    </div>
  );
};

export default ListItem;
