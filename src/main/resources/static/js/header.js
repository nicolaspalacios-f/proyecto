function verificar() {
  if (sessionStorage.getItem("loggeado") === "false") {
    console.log(sessionStorage.getItem("loggeado"));
    window.location.href = "index.html";
  }
}
verificar();

function darNombre() {
  const element = (
    <div>
      <h1>Bienvenido {sessionStorage.getItem("User")}!</h1>
    </div>
  );
  ReactDOM.render(element, document.getElementById("usuario"));
}
darNombre();

function logout() {
  sessionStorage.setItem("loggeado", false);
  window.location.href = "index.html";
}

function redirectTablero() {
  window.location.href = "tablero.html";
}

function redirectKanvan() {
  var respuesta = prompt("Ingrese el nombre del kanban", "Kanban");
  fetch("api/kanban/create?nombre_kanban=" + respuesta, {
    method: "POST",
  })
    .then((data) => data.json())
    .then((data) => {
      sessionStorage.setItem("nombre_kanban", respuesta);
      fetch(
        "api/usuariosxkanban/crearUsuarioxKanban?id_usuario=" +
          sessionStorage.getItem("id_usuario") +
          "&id_kanban=" +
          data.id,
        { method: "POST" }
      ).then((window.location.href = "kanvan.html"));
    });
}
function loadKanban(nombre_kanban) {
  sessionStorage.setItem("nombre_kanban", nombre_kanban);
  window.location.href = "kanvan.html";
}
function redirectHome() {
  window.location.href = "home.html";
}
