import React, { Component } from "react";
import AnimaniaService from "../services/animaniaService";
import { Link } from "react-router-dom";


export default class AnimalLista extends Component {
  constructor(props) {
    super(props);
    this.retrieveAnimales = this.retrieveAnimales.bind(this);
    this.refreshList = this.refreshList.bind(this);
    this.setActiveAnimal = this.setActiveAnimal.bind(this);

    this.state = {
      animales: [],
      currentAnimales: null,
      currentIndex: -1,
    };
  }

  componentDidMount() {
    this.retrieveAnimales();
  }

  retrieveAnimales() {
    AnimaniaService.getAll()
      .then(response => {
        this.setState({
          animales: response.data
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  refreshList() {
    this.retrieveAnimales();
    this.setState({
      currentTutorial: null,
      currentIndex: -1
    });
  }

  setActiveAnimal(animal, index) {
    this.setState({
      currentAnimales: animal,
      currentIndex: index
    });
  }

  render() {
    const { animales, currentAnimales, currentIndex } = this.state;

    return (
      <div className="row">
        <div className="col-md-3">
          <h4><strong>Lista de animales</strong></h4>
          <table>
            <tr>
              <th>Nombre</th>
            </tr>
            <tr>
              <td>
                {animales &&
                  animales.map((currentAnimales, index) => (
                    <li
                      className={
                        "list-group-item " +
                        (index === currentIndex ? "active" : "")
                      }
                      onClick={() => this.setActiveAnimal(currentAnimales, index)}
                      key={index}
                    >
                      {currentAnimales.nombreAnimal}
                    </li>
                  ))}
              </td>
            </tr>
          </table>

        </div>
      </div>
    );
  }
}
