import React, { Component } from "react";
import { BrowserRouter as Router } from "react-router-dom";
import { Route } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

import Header from './components/Header'
import SecondHeader from './components/SecondHeader'
import AnadirAnimal from './components/anidarAnimal'
import AnimalLista from './components/animalLista'
import "./App.css";

class App extends Component {
  constructor(props) {
    super(props);
      this.state = {
        user: null
      }
  }

  componentDidMount () {
    
  }

  handleAuth() {
    
  }

  handleLogout() {
   
  }

  render() {
    return (
      this.state.user ?
      <Router>
      <div>
        <Header
          appName='Animania'
          user={this.state.user}
          onAuth={this.handleAuth.bind(this)}
          onLogout={this.handleLogout.bind(this)}
          />
      </div>
      </Router>

      :
      <Router>
      <div>
        <Header
          appName='Animania'
          user={this.state.user}
          onAuth={this.handleAuth.bind(this)}
          onLogout={this.handleLogout.bind(this)}
          />
      </div>

      <div>
        <SecondHeader
          user={this.state.user}
          onAuth={this.handleAuth.bind(this)}
          onLogout={this.handleLogout.bind(this)}
          />
      </div>

      <Route exact path="/add" component={AnadirAnimal}/>
      <Route path="/inicio" component={AnimalLista}/>
      </Router>
    );
  }
}

export default App;
