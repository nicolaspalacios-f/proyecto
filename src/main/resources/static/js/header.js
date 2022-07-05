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
  window.location.href = "kanvan.html";
}
function redirectHome() {
  window.location.href = "home.html";
}
