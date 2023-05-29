import React, { useState, useEffect } from "react";
import { useSelector } from "react-redux";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { deleteMovie, updateMovie } from "../services/MovieService";
import { getAllWatchlists } from "../services/WatchlistService";

const EditFilmModal = ({
  user,
  currentListId,
  watchedTab,
  film,
  idToken,
  onClose,
}) => {
  const [toWatch, setToWatch] = useState(!watchedTab);
  const [watched, setWatched] = useState(watchedTab);
  const [rating, setRating] = useState(null);
  const [comment, setComment] = useState(null);
  const [watchlists, setWatchlists] = useState([]);
  const [watchlistId, setSelectedListId] = useState(0);
  const [watchedDate, setWatchedDate] = useState(new Date());

  const fetchWatchlists = () => {
    // const response = await getAllWatchlists(user.id, idToken);
    try {
      getAllWatchlists(user.id, idToken).then((data) => {
        console.log("Modal - watchlists fetched: ", data);
        setWatchlists(data);
        console.log("Modal - watchlists set: ", watchlists);
      });
      // console.log("Modal - watchlists fetched: ", response);
      // setWatchlists(response.data);
    } catch (error) {
      // handle error
      console.log("Modal - error fetching watchlists: ", error);
    }
  };

  const setDropdown = () => {
    try {
      console.log("Modal - setting dropdown: ", watchlists);
      setSelectedListId(watchlists[0].name);
    } catch (error) {
      console.log("Modal - error setting dropdown: ", error);
    }
  };

  useEffect(() => {
    console.log("Edit film modal");
    fetchWatchlists();
  }, []);

  const onToWatchChange = (e) => {
    setToWatch(e.target.checked);
    setWatched(false);
  };

  const onWatchedChange = (e) => {
    setDropdown();
    setWatched(e.target.checked);
    setToWatch(false);
  };

  const onRatingChange = (e) => {
    setRating(parseInt(e.target.value));
  };

  const onCommentChange = (e) => {
    setComment(e.target.value);
  };

  const onRemove = () => {
    try {
      console.log("Modal - trying to remove: ", film);
      deleteMovie(currentListId, film.id, idToken).then((res) => {
        console.log("Modal - deleteMovie response: ", res);
        if (res.state === 200) {
          console.log("Modal - Movie successfuly removed.");
          onClose();
        }
      });
    } catch (error) {
      console.log(error);
    }
  };

  const onCancel = () => {
    onClose();
  };

  const onSelectList = (e) => {
    setSelectedListId(e.target.value);
    console.log("Modal - selected list: ", watchlistId);
    console.log("Modal - selected list e: ", e.target.value);
  };

  const onWatchedDateChange = (date) => {
    setWatchedDate(date);
  };

  const onConfirm = async () => {
    try {
      const modificationDate = new Date().toISOString();
      // console.log("Modal - selected watchlist id: ", watchlistId);

      if (watched && (!watchedDate || !rating || !comment || !watchlistId)) {
        alert("Please fill in all fields.");
        // return;
      } else if (!watched && !watchlistId) {
        alert("Please select a watchlist.");
        // return;
      } else {
        console.log(
          "Modal - trying to edit: ",
          watched,
          ",",
          watchedDate.toISOString(),
          ",",
          rating,
          ",",
          comment,
          ",",
          modificationDate,
          ",",
          film.id,
          ",",
          watchlistId
          // ",",
          // idToken
        );

        updateMovie(
          watched,
          watchedDate.toISOString(),
          rating,
          comment,
          modificationDate,
          film.id,
          currentListId, //oldListId
          watchlistId, //newListId
          idToken
        ).then((res) => {
          // console.log("Modal - updateMovie response: ", res)
          if (res.state === 200) {
            console.log("Modal - Movie successfuly updated.");
            onClose();
          }
        });
      }
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="modal is-active">
      <div className="modal-background" onClick={onClose} />
      <div className="modal-content">
        <div className="box">
          <div className="columns is-multiline">
            <div className="column is-half">
              <p>
                <strong>Name:</strong> {film.name}
              </p>
              <p>
                <strong>Year:</strong> {film.year}
              </p>
              <p>
                <strong>IMDB ID:</strong> {film.imdbId}
              </p>
            </div>
            <div className="column is-half">
              <label className="checkbox">
                <input
                  type="checkbox"
                  checked={toWatch}
                  onChange={onToWatchChange}
                />
                To Watch
              </label>
              <label className="checkbox">
                <input
                  type="checkbox"
                  checked={watched}
                  onChange={onWatchedChange}
                />
                Watched
              </label>
              {watched && (
                <div>
                  <p>My Rating:</p>
                  <div className="field has-addons">
                    {[1, 2, 3, 4, 5].map((num) => (
                      <div className="control" key={num}>
                        <label className="radio">
                          <input
                            type="radio"
                            name="rating"
                            value={num}
                            onChange={onRatingChange}
                          />
                          {num}
                        </label>
                      </div>
                    ))}
                  </div>
                  <p>My Comments:</p>
                  <textarea className="textarea" onChange={onCommentChange} />

                  {/* input for watched date */}
                  <p>Watched Date:</p>
                  <DatePicker
                    id="watchedDate"
                    selected={watchedDate}
                    onChange={onWatchedDateChange}
                  />
                </div>
              )}
              <h5>Select a list to add to:</h5>
              <select value={watchlistId} onChange={onSelectList}>
                <option value="">Select a list</option>
                {watchlists.map((list) => (
                  <option key={list.id} value={list.id}>
                    {list.name}
                  </option>
                ))}
              </select>
            </div>
          </div>
          <hr />
          <p>Edited on: {new Date().toLocaleDateString()}</p>
          <div className="buttons is-right">
            <button className="button is-danger" onClick={onRemove}>
              Remove
            </button>
            <button className="button" onClick={onCancel}>
              Cancel
            </button>
            <button
              className="button is-success"
              onClick={onConfirm}
              disabled={!toWatch && !watched}
            >
              Confirm
            </button>
          </div>
        </div>
      </div>
      <button
        className="modal-close is-large"
        aria-label="close"
        onClick={onClose}
      />
    </div>
  );
};
export default EditFilmModal;
