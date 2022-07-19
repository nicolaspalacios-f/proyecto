var info = "Elimina el postit para iniciar";

class Postit extends React.Component {
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
      <div id="tarea">
        <br></br>
        <button id="bottonAnadir" data-target-modal="#todo_form">
          Añadir Post-it
        </button>
        <div class="postit post-it" draggable="true" columna="columna_1">
          <li>{info}</li>
          
        </div>
        <div id="overlay"></div>
      </div>
    );
    return elemento;
  }
}
ReactDOM.render(<Postit />, document.getElementById("postit"));
