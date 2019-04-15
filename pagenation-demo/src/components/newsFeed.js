import React from 'react';


function NewsFeed (props) {

  let styles = {
    maxWidth: '700px'
  };
  return (


      <div >
      <div className="card border-dark bg-light text-dark text-center p-3 mb-3 ml-5 mr-5" style={styles}>
        <div className="card-body">
          <h5 className="card-header  text-white bg-dark">{props.category}</h5>
          <h6 className="card-subtitle text-white mb-2 bg-dark">{props.pubDate}</h6>
        </div>
        <div className="card-body">
          <h3 className="card-title">{props.headline}</h3>
          <p className="card-text">{props.snippet}</p>
          <a href={props.webURL} className="btn btn-dark">Read more</a>
        </div>
      </div>
      </div>



  );
}

export default NewsFeed;
