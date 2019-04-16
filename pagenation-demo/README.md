# Pagenation demo with react app.

## Setting up the react app from command line

You’ll need to have Node >= 6 and npm >= 5.2 on your machine. To create a project. </br>


```sh
npx create-react-app react-pagenation-demo
cd react-pagenation-demo
npm start

```
It will create a directory called `react-pagenation-demo` inside the current folder.<br>
Inside that directory, it will generate the initial project structure and install the transitive dependencies:

```
react-pagenation-demo
├── README.md
├── node_modules
├── package.json
├── .gitignore
├── public
│   ├── favicon.ico
│   ├── index.html
│   └── manifest.json
└── src
    ├── App.css
    ├── App.js
    ├── App.test.js
    ├── index.css
    ├── index.js
    ├── logo.svg
    └── serviceWorker.js
```
```sh
cd react-pagenation-demo 
```

Inside the newly created project, you can run some built-in commands:

### `npm start` or `yarn start`

Runs the app in development mode.<br>

Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

## Adding Bootrap to the app

```sh
npm install --save bootstrap
```

Then add the following import statement to index.js file:

```
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
// Put any other imports below so that CSS from your
// components takes precedence over default styles.
```

## Let us see if the following bootstrap is installed.

### create a header.js

```js
import React from 'react';

const Header = () => {

  return (
    <div className="jumbotron ">
      <div className="container">
        <h1 className="display-4 ">React Pagenation Demo</h1>
        <p className="lead">This is a modified jumbotron that occupies the entire horizontal space of its parent.</p>
      </div>
    </div>
    );
  };

  export default Header;
```

## Adding react-js-pagination package for pagination and axios for http request.

```sh

npm install react-js-pagination
npm install axios

```

### Demo

![Demo](https://i.imgur.com/Nb0Q0oS.gif)


