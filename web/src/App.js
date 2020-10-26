import React, { useState } from 'react';
import './App.css';
import Home from './views/landing';
import Login from 'components/forms/login';
import Register from 'components/forms/register';
import Navbar from './components/navbar';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import userContext from 'context/userContext';

function App() {

  const [user, setUser] = useState(JSON.parse(localStorage.getItem('user')));

  return (

    <userContext.Provider value={ user ? {...user, logout: () => setUser(null)} : null}>
      <div>

          <Navbar />

          <div className='has-background-light' style={{minHeight: 'calc(100vh - 70px)'}}>
            <Router>
              <Switch>
                <Route exact={true} path='/' component={Home} />

                <Route
                    exact={true}
                    path='/login'
                    render={props => <Login {...props} storeUser={setUser} />}
                />

                <Route exact={true} path='/register' component={Register} />

              </Switch>
            </Router>
          </div>

      </div>
    </userContext.Provider>
  );
}

export default App;
