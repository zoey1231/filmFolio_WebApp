import React, { useState, useContext } from "react";
import { addWatchlist } from "../services/WatchlistService";
import { ListRefreshContext } from "../context/ListRefreshContext";

const AddListModal = ({ user, idToken, onClose }) => {
  //use the context
  const { triggerRefresh } = useContext(ListRefreshContext);

  const [listName, setListName] = useState("");

  const onListNameChange = (e) => {
    setListName(e.target.value);
  };

  const onCancel = () => {
    onClose();
  };

  const onConfirm = async () => {
    if (!listName) {
      alert("Please enter a new name.");
    } else {
      await addWatchlist(user.id, listName, idToken); // Use await here to make sure it's done before triggering refresh
      console.log("list modal - add new list: ", listName);
      triggerRefresh(); // Call triggerRefresh after adding a new watchlist
      onClose();
    }
  };

  return (
    <div className="modal is-active">
      <div className="modal-background" onClick={onClose}></div>
      <div className="modal-content">
        <div className="box">
          <p className="new-list-name">
            What would you like to name the new list?
          </p>
          <textarea
            className="textarea one-liner"
            onChange={onListNameChange}
            rows="1"
          ></textarea>
          <div className="buttons is-right">
            <button className="button" onClick={onCancel}>
              Cancel
            </button>
            <button
              className="button is-success"
              onClick={onConfirm}
              // disabled={newname}
            >
              Confirm
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddListModal;
