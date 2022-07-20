var info = "";

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
        <div class="postit post-it" draggable="true" columna="columna_1">
          <li>{info}</li>
        </div>
      </div>
    );
    return info != "" ? elemento : null;
  }
}
ReactDOM.render(<Postit />, document.getElementById("postit"));
