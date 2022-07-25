import React from "react";
import "../styles/Notebook.css";
import FormInput from "../components/FormInput";

const Notebook = () => {
  return (
    <div className="container-fluid">
      <div className="row">
        <div className="col-sm-12">
          <h1>Welcome to My Lab Journal</h1>
          <h4>
            Your favourite tool to find word frequency and similar words in your
            paper <br /> to better understand similarities in your data.
          </h4>
        </div>
      </div>
      <div className="row">
        <div className="col-sm">
          <div className="hero-container">
            <FormInput />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Notebook;
