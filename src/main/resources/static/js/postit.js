var titulo = "perro";
var info = "gato";

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
        <h2>{titulo}</h2>
        <br></br>
        <button id="bottonAnadir">Añadir postit</button>
        <div className="post">
          <div className="post-it" contentEditable draggable="true">
            <li>{info}</li>
          </div>
        </div>
      </div>
    );
    return elemento;
  }
}
//ReactDOM.render(<Postit />, document.getElementById("postit"));
