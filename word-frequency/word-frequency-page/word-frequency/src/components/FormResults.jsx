import React from "react";

const FormResults = ({ labEntry }) => {
  return (
    <>
      <div>
        <div className="container-fluid">
          <div className="row">
            <div className="col-sm-12">
              <h2>Results of analyzing your data:</h2>
            </div>
            <div className="col-sm-12">
              <p>
                Topic of this paper: <strong>{labEntry.topic}</strong>
              </p>
              <p>
                You asked for the frequency of the word:{" "}
                <strong>{labEntry.solicitedWord}</strong>
              </p>
              <p>
                This word has a frequency of{" "}
                <strong>
                  {labEntry.wordFrequency > 0 ? labEntry.wordFrequency : 0}
                </strong>{" "}
                times in your paper!
              </p>
              <p>Similar words found: </p>
              <ul>
                {!labEntry.similarWords || labEntry.similarWords.length === 0
                  ? "None!"
                  : labEntry.similarWords.map((w, index) => (
                      <li key={index}>{w}</li>
                    ))}
              </ul>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default FormResults;
