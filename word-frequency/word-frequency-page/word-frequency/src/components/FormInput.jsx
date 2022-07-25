import React, { useState } from "react";
import "../styles/FormInput.css";
import axios from "axios";
import FormResults from "./FormResults";

const FormInput = () => {
  const [submitted, setSubmitted] = useState(false);
  const [errors, setErrors] = useState({ message: "" });
  const [formData, setFormData] = useState({
    researcherName: "",
    topic: "",
    entry: "",
    solicitedWord: "",
  });
  const [labResults, setLabResults] = useState({
    topic: "",
    solicitedWord: "",
    wordFrequency: "",
    similarWords: [],
  });

  function handleFormDataEntry(e) {
    const updatedData = { ...formData };
    updatedData[e.target.id] = e.target.value;
    setFormData(updatedData);
  }

  const validate = (values) => {
    const errors = {};
    if (Object.values(values).some((x) => x === "")) {
      errors.message = "Please complete all fields to submit!";
      setErrors(errors);
    }
    return errors;
  };

  function handleSubmit(e) {
    e.preventDefault();
    setErrors(validate(formData));
    if (
      !Object.values(formData).some((x) => x === "" || x === null) &&
      !submitted
    ) {
      axios
        .post(`http://localhost:8080/notebook/add`, formData)
        .then((response) => {
          setSubmitted(!submitted);
          setLabResults(response.data);
          setFormData({});
          e.target.reset();
        })
        .catch((error) => {
          console.log(error.response);
        });
    }
  }

  return (
    <>
      <div className="form-container">
        {submitted &&
        !Object.values(labResults).every((x) => x === "" || x === null) ? (
          <FormResults labEntry={labResults} />
        ) : (
          <form onSubmit={(e) => handleSubmit(e)}>
            <div className="form-group">
              <div className="label-input">
                <label htmlFor="researcherName">Researcher Name*</label>
              </div>
              <input
                type="text"
                className="form-control"
                id="researcherName"
                placeholder="Write your name here"
                onChange={(e) => handleFormDataEntry(e)}
              />
            </div>

            <div className="form-group">
              <div className="label-input">
                <label htmlFor="topic">Topic*</label>
              </div>
              <input
                type="text"
                className="form-control"
                id="topic"
                placeholder="What's the topic?"
                onChange={(e) => handleFormDataEntry(e)}
              />
            </div>
            <div className="form-group">
              <div className="label-input">
                <label htmlFor="entry">My Paper*</label>
              </div>
              <textarea
                type="text"
                className="form-control"
                id="entry"
                onChange={(e) => handleFormDataEntry(e)}
                placeholder="Write your paper here"
              />
            </div>
            <div className="form-group">
              <div className="label-input">
                <label htmlFor="solicitedWord">Word of Interest*</label>
              </div>
              <input
                type="text"
                className="form-control"
                id="solicitedWord"
                placeholder="Choose a word to analyze its frequency and similarities!"
                onChange={(e) => handleFormDataEntry(e)}
              />
            </div>
            <p style={{ color: "red" }}>{errors.message}</p>
            <div className="form-group">
              <button className="button-56" type="submit">
                Submit your paper
              </button>
            </div>
          </form>
        )}
      </div>
    </>
  );
};

export default FormInput;
