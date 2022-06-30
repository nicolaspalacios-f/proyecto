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
        <div>
          <div className="column">
            <h2>Por Hacer</h2>
            <br></br>
            <div className="tarea1">
              <div className="post-it" contentEditable>
                <h1>Sticky note</h1>
                <li></li>
              </div>
            </div>
          </div>
          <div className="column">
            <h2>En proceso</h2>
            <br></br>
            <div className="tarea2">
              <div className="post-it" contentEditable>
                <h1>Sticky note</h1>
              </div>
            </div>
          </div>
          <div className="column">
            <h2>Terminado</h2>
            <br></br>
            <div className="tarea3">
              <div className="post-it" contentEditable>
                <h1>Sticky note</h1>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
    return elemento;
  }
}

ReactDOM.render(<StatusComponent />, document.getElementById("kanva"));
