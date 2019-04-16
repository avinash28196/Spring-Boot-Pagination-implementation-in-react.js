import React from 'react';


function NewsFeed (props) {

  let styles = {
    maxWidth: '700px'
  };


  return (
      <div className="card border-dark bg-light text-dark text-center p-3 mb-3 ml-5 mr-5" style={styles}>
        <div className="card-header">
          <h2>{props.headline}</h2>
          <h4 className="card-title btn btn-secondary">{props.category}</h4>
        </div>
        <div className="card-body">

          <small className="text-muted mb-3">{props.pubDate}</small>
          <p className="card-text">{props.snippet}</p>
        </div>
        <div className="card-footer">
          <a href={props.webURL} className="btn btn-secondary">Read more</a>
        </div>
      </div>
  );
}

export default NewsFeed;
