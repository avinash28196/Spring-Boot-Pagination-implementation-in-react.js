import React from 'react';
import axios from 'axios';
import Pagination from "react-js-pagination";
import NewsFeed  from './newsFeed.js';

class FetchNews extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      articlesDetails: [],
      activePage:1,
      totalPages: null,
      itemsCountPerPage:null,
      totalItemsCount:null
    };
    this.handlePageChange = this.handlePageChange.bind(this);
    this.fetchURL = this.fetchURL.bind(this);
  }

  fetchURL(page) {

    axios.get(`http://localhost:8090/articles?page=${page}&size=5`)
      .then( response => {

          const totalPages = response.data.totalPages;
          const itemsCountPerPage = response.data.size;
          const totalItemsCount = response.data.totalElements;

          this.setState({totalPages: totalPages})
          this.setState({totalItemsCount: totalItemsCount})
          this.setState({itemsCountPerPage: itemsCountPerPage})

          const results = response.data.content;

          const updatedResults = results.map(results => {

            var timestamp = new Date(results.pubDate)
            var dateString = timestamp.toGMTString()
            return {
                ...results, dateString
              }
            });

            this.setState({articlesDetails: updatedResults});
            console.log(updatedResults);
            console.log(this.state.activePage);
            console.log(this.state.itemsCountPerPage);

        }
      );
    }

  componentDidMount () {
      this.fetchURL(this.state.activePage)
    }

  handlePageChange(pageNumber) {
    console.log(`active page is ${pageNumber}`);
    this.setState({activePage: pageNumber})
    this.fetchURL(pageNumber)

    }

  populateRowsWithData = () => {
    const articleData = this.state.articlesDetails.map(article => {
        return <NewsFeed
            key = {article.id}
            headline = {article.headline}
            category = {article.category}
            pubDate = {article.dateString}
            snippet = {article.snippet}
            webURL = {article.webURL}
          />;
      });

      return articleData
    }

  render(){

    return (
      <div >

      {this.populateRowsWithData()}

      <div className="d-flex justify-content-center">
        <Pagination
         hideNavigation
         activePage={this.state.activePage}
         itemsCountPerPage={this.state.itemsCountPerPage}
         totalItemsCount={this.state.totalItemsCount}
         pageRangeDisplayed={10}
         itemClass='page-item'
         linkClass='btn btn-light'
         onChange={this.handlePageChange}
         />
       </div>
      </div>
    );
  }
}

export default FetchNews;
