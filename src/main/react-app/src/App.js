import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import { Outlet, Link } from 'react-router-dom';

class App extends Component {
  render() {
    return (
      <div>
        <img src={logo} className="App-logo" alt="logo" />
        <h1>Hello World!</h1>
        <nav>
          <Link to="/destination">Destinations</Link> | {" "}
          <Link to="/mileage">Mileages</Link>
        </nav>
        <p>Created first React App</p>
        <Outlet />
      </div>
    );
  }
}

/** Initialized React-App
 *  Default React-app page
 */
// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

export default App;
