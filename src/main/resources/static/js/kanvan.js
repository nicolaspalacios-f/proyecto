class StatusComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      status: "",
      title: "",
    };
    this.handleTitle = this.handleTitle.bind(this);

  }
  handleTitle(event) {
    this.setState({ title: event.target.value });
  }
  render() {
    const elemento = (
      <div>
        <h1 id="nomrbdf"><input className="inputTitulo" placeholder = "Inserte nombre de kanban" onChange={this.handleTitle} value={this.state.title}/></h1>
        <div class="contenedor">
          <div className="column" id="columna_1">
            <h2>Por hacer</h2>
            <br></br>
            <div id="postit"></div>
          </div>
          <div className="column" id="columna_2">
            <h2>En proceso</h2>
            <br></br>
            <div id="postit"></div>
          </div>
          <div className="column" id="columna_3">
            <h2>Terminado</h2>
            <br></br>
            <div id="postit"></div>
          </div>
          <div className="column" id="columna_4">
            <h2>Eliminar</h2>
            <br></br>
            <div id="postit"></div>
          </div>
        </div>
      </div>
    );
    return elemento;
  }
}

ReactDOM.render(<StatusComponent />, document.getElementById("kanva"));
