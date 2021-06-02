import React, { Component } from "react";
import animaniaService from "../services/animaniaService";

export default class AnadirAnimal extends Component {
  constructor(props) {
    super(props);

    this.onChangeNombreAnimal = this.onChangeNombreAnimal.bind(this);
    this.onChangeTipoAnimal = this.onChangeTipoAnimal.bind(this);
    this.onChangeCiudad = this.onChangeCiudad.bind(this);
    this.onChangeSexo = this.onChangeSexo.bind(this);
    this.onChangeFechaNac = this.onChangeFechaNac.bind(this);
    this.onChangeUrgenciaAnimal = this.onChangeUrgenciaAnimal.bind(this);
    this.onChangeDescripcion = this.onChangeDescripcion.bind(this);

    this.saveAnimal = this.saveAnimal.bind(this);
    this.newAnimal = this.newAnimal.bind(this);


    this.state = {
      id: null,
      nombreAnimal: "",
      tipoAnimal: "", 
      ciudad: "",
      sexo: "",
      fechaNac: "",
      urgenciaAnimal: "",
      fotoAnimal: "",
      descripcion: "",

      submitted: false
    };
  }

  onChangeNombreAnimal(e) {
    this.setState({
      nombreAnimal: e.target.value
    });
  }

  onChangeTipoAnimal(e) {
    this.setState({
      tipoAnimal: e.target.value
    });
  }

  onChangeCiudad(e) {
    this.setState({
      ciudad: e.target.value
    });
  }

  onChangeSexo(e) {
    this.setState({
      sexo: e.target.value
    });
  }

  onChangeFechaNac(e) {
    this.setState({
      fechaNac: e.target.value
    });
  }

  onChangeUrgenciaAnimal(e) {
    this.setState({
      urgenciaAnimal: e.target.value
    });
  }

  onChangeDescripcion(e) {
    this.setState({
      descripcion: e.target.value
    });
  }

  saveAnimal() {
    var data = {
      nombreAnimal: this.state.nombreAnimal,
      tipoAnimal: this.state.tipoAnimal,
      ciudad: this.state.ciudad,
      sexo: this.state.sexo,
      fechaNac: this.state.fechaNac,
      urgenciaAnimal: this.state.urgenciaAnimal,
      fotoAnimal: this.state.fotoAnimal,
      descripcion: this.state.descripcion

    };

    animaniaService.create(data)
      .then(response => {
        this.setState({
          id: response.data.id,
          nombreAnimal: response.data.nombreAnimal,
          tipoAnimal: response.data.tipoAnimal,
          ciudad: response.data.ciudad,
          sexo: response.data.sexo,
          fechaNac: response.data.fechaNac,
          urgenciaAnimal: response.data.urgenciaAnimal,
          fotoAnimal: response.data.fotoAnimal,
          descripcion: response.data.descripcion,

          submitted: true
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  newAnimal() {
    this.setState({
      id: null,
      nombreAnimal: "",
      tipoAnimal: "", 
      ciudad: "",
      sexo: "",
      fechaNac: "",
      urgenciaAnimal: "",
      fotoAnimal: "",
      descripcion: "",

      submitted: false
    });
  }

  render() {
    return (
      <div className="submit-form">
        {this.state.submitted ? (
          <div>
            <h4>¡Ficha del animal añadida con éxito!</h4>
            <button className="btn btn-success" onClick={this.newAnimal}>
              Volver a añadir otro
            </button>
          </div>

        ) : (

          <div>
            <div className="form-group">
              <label htmlFor="nombreAnimal">Nombre</label>
              <input
                type="text"
                className="form-control"
                id="nombreAnimal"
                required
                value={this.state.nombreAnimal}
                onChange={this.onChangeNombreAnimal}
                name="name"
              />
            </div>

            <div className="form-group">
              <label htmlFor="tipoAnimal">Tipo</label>
              <input
                type="text"
                className="form-control"
                id="tipoAnimal"
                required
                value={this.state.tipoAnimal}
                onChange={this.onChangeTipoAnimal}
                name="tipoAnimal"
              />
            </div>

            <div className="form-group">
              <label htmlFor="ciudad">Ciudad</label>
              <input
                type="text"
                className="form-control"
                id="ciudad"
                required
                value={this.state.ciudad}
                onChange={this.onChangeCiudad}
                name="ciudad"
              />
            </div>

            <div className="form-group">
              <label htmlFor="sexo">Sexo</label>
              <input
                type="text"
                className="form-control"
                id="sexo"
                required
                value={this.state.sexo}
                onChange={this.onChangeSexo}
                name="sexo"
              />
            </div>

            <div className="form-group">
              <label htmlFor="fechaNac">Fecha nacimiento</label>
              <input
                type="date"
                className="form-control"
                id="fechaNac"
                required
                value={this.state.fechaNac}
                onChange={this.onChangeFechaNac}
                name="fechaNac"
              />
            </div>

            <div className="form-group">
              <label htmlFor="urgenciaAnimal">Urgencia</label>
              <input
                type="text"
                className="form-control"
                id="urgenciaAnimal"
                required
                value={this.state.urgenciaAnimal}
                onChange={this.onChangeUrgenciaAnimal}
                name="urgenciaAnimal"
              />
            </div>

            <div className="form-group">
              <label htmlFor="descripcion">Descripción</label>
              <input
                type="text"
                className="form-control"
                id="descripcion"
                required
                value={this.state.descripcion}
                onChange={this.onChangeDescripcion}
                name="descripcion"
              />
            </div>

            <div className="App">
            <input type="file" name="fotoAnimal"/>
            </div>
            <button onClick={this.saveAnimal} className="btn btn-success">
              Subir animal
            </button>
          </div>
        )}
      </div>
    );
  }
}
