import React, { Component } from 'react';

import './App.css';

import Header from './components/header.js';
import FetchNews  from './components/fetchNews.js';

class App extends Component {
  render() {
    return (
      <div>
        <Header />
        <div className="d-flex justify-content-center">
          <FetchNews />
        </div>
      </div>
    );
  }
}

export default App;
