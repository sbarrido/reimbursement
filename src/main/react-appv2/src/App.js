import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import { Outlet } from 'react-router-dom';
import {
  Container,
  Col,
  Row
} from 'reactstrap';
import GlobalNav from './components/GlobalNav'

class App extends Component {
  
  render() {
    return (
      <div>
        <img src={logo} className="App-logo" alt="logo" />
        <Container>
          <Row>
          <Col xs="auto">
            <GlobalNav/>
          </Col>
          <Col fluid="true">
            <main>
              <Outlet/>
            </main>
          </Col>
          </Row>
        </Container>
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
