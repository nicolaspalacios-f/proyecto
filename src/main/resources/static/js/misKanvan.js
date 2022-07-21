function getAllKanbans() {
  fetch("/api/usuariosxkanban/findAll")
    .then((data) => data.json())
    .then((data) => {
      if (data != null) {
        var subjects = document.getElementById("variosKanban");
        data.forEach((element) => {
          if (element.idUsuario.usuario == sessionStorage.getItem("User")) {
            console.log(element);
            var option = document.createElement("button");
            option.setAttribute("type", "button");
            option.setAttribute("class", "boton");
            option.innerHTML = element.idKanban.nombre_kanban;
            option.setAttribute(
              "onclick",
              "loadKanban('" + element.idKanban.nombre_kanban + "')"
            );
            subjects.appendChild(option);
          }
        });
      } else {
        console.log("Materias no encontradas.");
      }
    });
}

function getNames() {
  var listaParejas = [];
  fetch("/api/usuariosxkanban/findAll", { method: "GET" })
    .then((data) => data.json())
    .then((data) => {
      if (data != null) {
        var subjects = document.getElementById("subjects");
        data.forEach((element) => {
          if (element.idUsuario.usuario != sessionStorage.getItem("User")) {
            listaParejas.push("" + element.idKanban.id);
          }
        });
        data.forEach((element) => {
          if (!listaParejas.includes(sessionStorage.getItem("idKanban"))) {
            if (
              element != sessionStorage.getItem("idKanban") &&
              element.idUsuario.usuario != sessionStorage.getItem("User")
            ) {
              var option = document.createElement("option");
              option.text = element.idUsuario.usuario;
              option.value = element.idUsuario.id;
              option.setAttribute("idusuario", element.id);
              subjects.add(option);
            }
          }
        });
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
