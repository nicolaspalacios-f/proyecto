function getAllKanbans() {
  fetch("/api/kanban/findAll")
    .then((data) => data.json())
    .then((data) => {
      if (data != null) {
        var subjects = document.getElementById("variosKanban");
        console.log(data);
        data.forEach((element) => {
          var option = document.createElement("button");
          console.log(option);
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
