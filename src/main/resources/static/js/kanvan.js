class StatusComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      status: "",
    };
  }
  render() {
    const elemento = (
      <div>
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
        </div>
      </div>
    );
    return elemento;
  }
}

ReactDOM.render(<StatusComponent />, document.getElementById("kanva"));
