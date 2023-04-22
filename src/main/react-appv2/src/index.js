import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import Destination from './routes/destination';
import Mileage from './routes/mileage';
import OtherExp from './routes/otherExp';
import User from './routes/UsersComponent';
import Form from './routes/createForm';
import reportWebVitals from './reportWebVitals';
import { 
  BrowserRouter,
  Routes,
  Route
} from 'react-router-dom';

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />}>
          <Route path="/destinations" element={<Destination />} />
          <Route path="/mileages" element={<Mileage />} />
          <Route path="/otherExps" element={<OtherExp />} />
          <Route path="/users" element={<User />} />\
          <Route path="/createForm" element={<Form /> } />
        </Route>
      </Routes>
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
