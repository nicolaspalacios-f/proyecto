class StatusComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      status: "",
      title: "",
    };
    fetch(
      "api/kanban/findByName?nombre_kanban=" +
        sessionStorage.getItem("nombre_kanban")
    )
      .then((data) => data.json())
      .then((data) => {
        this.setState({ title: data.nombre_kanban });
        sessionStorage.setItem("idKanban", data.id);
        fetch("api/postit/getAllByKanban?id_kanban=" + data.id)
          .then((data1) => data1.json())
          .then((data1) => {
            function crearRecibidoo(json) {
              const todo_div = document.createElement("div");
              const txt = document.createTextNode(json.informacion);

              todo_div.appendChild(txt);
              todo_div.classList.add("post-it");
              todo_div.classList.add("postit");
              todo_div.setAttribute("draggable", "true");
              todo_div.setAttribute("columna", json.columna);
              if (!(todo_div.getAttribute("columna") === "columna_4")) {
                todo_div.setAttribute("id", json.id);
                /* create span */
                const span = document.createElement("span");
                const span_txt = document.createTextNode("\u00D7");
                span.classList.add("close");

                todo_div.appendChild(span);
                var col = document.getElementById(json.columna);
                col.appendChild(todo_div);
                span.addEventListener("click", () => {
                  eliminar(span);
                });

                todo_div.addEventListener("dragstart", dragStart);
                todo_div.addEventListener("dragend", dragEnd);

                document.getElementById("todo_input").value = "";
                todo_form.classList.remove("active");
                overlay.classList.remove("active");
              }
            }
            Array.from(data1).forEach((postit) => {
              crearRecibidoo(postit);
            });
          });
      });

    this.handleTitle = this.handleTitle.bind(this);
  }

  handleTitle(event) {
    this.setState({ title: event.target.value });
    console.log(event.target.value);
  }
  render() {
    const elemento = (
      <div>
        <h1 id="nomrbdf">{this.state.title}</h1>
        <br />
        <div class="contenedor">
          <div className="column" id="columna_1">
            <h2>Por hacer</h2>
            <br></br>
            <button id="bottonAnadir" data-target-modal="#todo_form">
              Añadir Post-it
            </button>
            <div id="overlay"></div>
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
