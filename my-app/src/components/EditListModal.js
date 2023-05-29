import React, { useState, useContext } from "react";
import { updateListName, deleteWatchlist } from "../services/WatchlistService";
import { ListRefreshContext } from "../context/ListRefreshContext";

const EditListModal = ({ list, idToken, onClose }) => {
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
      try {
        await updateListName(list.id, listName, idToken);
        console.log("list modal - list w new name: ", list);
        triggerRefresh();
        onClose();
      } catch (error) {
        console.error("Error updating list name:", error);
      }
    }
  };

  const onDelete = async () => {
    try {
      await deleteWatchlist(list.id, idToken);
      triggerRefresh();
      onClose();
    } catch (error) {
      console.error("Error deleting watchlist:", error);
    }
  };

  return (
    <div className="modal is-active">
      <div className="modal-background" onClick={onClose}></div>
      <div className="modal-content">
        <div className="box">
          <p className="new-list-name">
            <strong>New list name: </strong>
          </p>
          <textarea
            className="textarea one-liner"
            onChange={onListNameChange}
            rows="1"
          ></textarea>
          <p>
            <strong>Current name:</strong> {list.name}
          </p>
          <div className="buttons is-right">
            <button className="button is-danger" onClick={onDelete}>
              Delete
            </button>
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

export default EditListModal;
