import React, { lazy, Suspense } from 'react';

import Header from './Components/Layouts/Header';
// import logo from './logo.svg';
import './App.css';
const OtherComponent = lazy(() => import('./Components/Rent/List'));

function App() {

  return (
    <div className="App">
      <Header />
      <Suspense fallback={<div>Loading...</div>}>
        <OtherComponent />
      </Suspense>
      {/* <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header> */}
      <div>
      </div>
    </div>
  );
}

export default App;
