function getAllKanbans() {
  fetch("/api/kanban/findAll")
    .then((data) => data.json())
    .then((data) => {
      if (data != null) {
        var subjects = document.getElementById("variosKanban");
        data.forEach((element) => {
          var option = document.createElement("button");
          option.setAttribute("type", "button");
          option.setAttribute("class", "boton");
          option.innerHTML = element.nombre_kanban;
          option.setAttribute(
            "onclick",
            "loadKanban('" + element.nombre_kanban + "')"
          );
          subjects.appendChild(option);
        });
      } else {
        console.log("Materias no encontradas.");
      }
    });
}

function getNames() {
  fetch("/api/usuariosxkanban/findAll", { method: "GET" })
    .then((data) => data.json())
    .then((data) => {
      console.log(data);
      if (data != null) {
        var subjects = document.getElementById("subjects");
        data.forEach((element) => {
          if (element.usuario != sessionStorage.getItem("User")) {
            var option = document.createElement("option");
            option.text = element.usuario;
            option.value = element.id;
            option.setAttribute("idusuario", element.id);
            subjects.add(option);
          }
          console.log(element);
        });
      } else {
        console.log("Materias no encontradas.");
      }
    });
}
function invitar() {
  var id_usuario = document.getElementById("subjects").value;
  var id_kanban = sessionStorage.getItem("idKanban");
  fetch(
    "/api/usuariosxkanban/crearUsuarioxKanban?id_usuario=" +
      id_usuario +
      "&id_kanban=" +
      id_kanban,
    { method: "POST" }
  );
  alert("Usuario invitado");
  document.getElementById("subjects").childNodes.forEach((element) => {
    if (element.value == id_usuario) {
      element.remove();
    }
  });
}
