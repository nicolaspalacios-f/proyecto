const postits = document.querySelectorAll(".postit");
const todos = document.querySelectorAll(".column");
var propietario = sessionStorage.getItem("User");
var datos = null;
let move = null;
var id;
postits.forEach((postit) => {
  postit.addEventListener("dragstart", dragStart);
  postit.addEventListener("dragend", dragEnd);
});

function dragStart() {
  move = this;
}
function dragEnd() {}

todos.forEach((status) => {
  status.addEventListener("dragover", dragOver);
  status.addEventListener("dragenter", dragEnter);
  status.addEventListener("dragout", dragOut);
  status.addEventListener("drop", drop);
});

function dragOver(e) {
  e.preventDefault();
  //console.log("dragover");
}
// cuando se entre a una posicion aceptable de una columna
function dragEnter() {}

// cuando se mueve encima de una columna
function dragOut() {}

function drop() {
  this.style.border = "none";

  this.appendChild(move);
  console.log(move);
  move.setAttribute("columna", this.getAttribute("id"));
  if (!(move.getAttribute("columna") === "columna_4")) {
    console.log(move, "a");
    console.log(move.getAttribute("columna"));
    datos = document.getElementById(move.getAttribute("id")).innerText;
    console.log(datos);
  } else {
    move.remove();
    fetch("api/postit/eliminarEnBase ", {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        id: move.getAttribute("id"),
        columna: move.getAttribute("columna"),
        informacion: datos,
        idKanban: sessionStorage.getItem("idKanban"),
      }),
    });
  }

  fetch("api/postit/updateEnBase ", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      id: move.getAttribute("id"),
      columna: move.getAttribute("columna"),
      informacion: datos,
      idKanban: sessionStorage.getItem("idKanban"),
    }),
  })
    .then((data) => data.json())
    .then((data) => {
      id = data.id;
      console.log(data);
    });
  var json = {
    column: move.getAttribute("columna"),
    idpostit: move.getAttribute("id"),
    textopost: datos,
    propi: propietario,
    accion: 1,
  };
  sincro(json);

  move = null;
}
/* modal */
const btns = document.querySelectorAll("[data-target-modal]");
const close_modals = document.querySelectorAll(".close-modal");
const overlay = document.getElementById("overlay");

btns.forEach((btn) => {
  btn.addEventListener("click", () => {
    document.querySelector(btn.dataset.targetModal).classList.add("active");
    overlay.classList.add("active");
  });
});

close_modals.forEach((btn) => {
  btn.addEventListener("click", () => {
    const modal = btn.closest(".modal");
    modal.classList.remove("active");
    overlay.classList.remove("active");
  });
});

window.onclick = (event) => {
  if (event.target == overlay) {
    const modals = document.querySelectorAll(".modal");
    modals.forEach((modal) => modal.classList.remove("active"));
    overlay.classList.remove("active");
  }
};
/* create todo  */
const todo_submit = document.getElementById("todo_submit");

//var id_kanban = document.getElementById("id_kanban").value;
todo_submit.addEventListener("click", createTodo);
//fetch("api/postit/id?id_kanban="+id_kanban) )

function createTodo() {
  fetch("api/postit/guardarEnBase ", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      id: 0,
      columna: "columna_1",
      informacion: document.getElementById("todo_input").value,
      idKanban: sessionStorage.getItem("idKanban"),
    }),
  })
    .then((data) => data.json())
    .then((data) => {
      id = data.id;
      const todo_div = document.createElement("div");
      const input_val = document.getElementById("todo_input").value;
      const txt = document.createTextNode(input_val);

      todo_div.appendChild(txt);
      todo_div.classList.add("post-it");
      todo_div.classList.add("postit");
      todo_div.setAttribute("draggable", "true");
      todo_div.setAttribute("columna", "columna_1");
      todo_div.setAttribute("id", id);

      /* create span */
      const span = document.createElement("span");
      const span_txt = document.createTextNode("\u00D7");
      span.classList.add("close");
      //span.appendChild(span_txt);
      span.setAttribute("className", "acaa");

      todo_div.appendChild(span);
      columna_1.appendChild(todo_div);
      span.addEventListener("click", () => {
        console.log(span);
        eliminar(span);
      });

      todo_div.addEventListener("dragstart", dragStart);
      todo_div.addEventListener("dragend", dragEnd);

      document.getElementById("todo_input").value = "";
      todo_form.classList.remove("active");
      overlay.classList.remove("active");
      datos = todo_div;
      console.log(datos.getAttribute("columna"), "perro");
      var json = {
        divHtml: datos,
        column: todo_div.getAttribute("columna"),
        textopost: input_val,
        idpostit: todo_div.getAttribute("id"),
        propi: propietario,
        accion: 0,
      };
      sincro(json);
    });
}

const close_btns = document.querySelectorAll(".close");

close_btns.forEach((btn) => {
  btn.addEventListener("click", () => {
    btn.parentElement.style.display = "none";
  });
});

/*---------------stomp--------------*/
var stompClient;
function setup() {
  stomp();
}
var colores = "#" + Math.floor(Math.random() * 16777215).toString(16);

function sincro(json) {
  stompClient.send(
    "/topic/kanvan" + sessionStorage.getItem("idKanban"),
    {},
    JSON.stringify(json)
  );
}

function stomp() {
  var socket = new SockJS("/stompEndpoint");
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
    console.log(frame);
    stompClient.subscribe(
      "/topic/kanvan" + sessionStorage.getItem("idKanban"),
      function (event) {
        var json = JSON.parse(event.body);

        if (json.propi != propietario) {
          switch (json.accion) {
            case 0:
              crearRecibido(json);
              break;
            case 1:
              console.log(json.idpostit);
              console.log("elimina");
              var docu = document.getElementById(json.idpostit);
              docu.remove();
              crearRecibido(json);
              break;
            case 4:
              var docu = document.getElementById(json.idpostit);
              docu.remove();
              //span.parentElement.style.display = "none";
              break;
          }
        }
      }
    );
  });
}
function eliminar(spa) {
  spa.parentElement.remove();
}
function crearRecibido(json) {
  const todo_div = document.createElement("div");
  const txt = document.createTextNode(json.textopost);

  todo_div.appendChild(txt);
  todo_div.classList.add("post-it");
  todo_div.classList.add("postit");
  todo_div.setAttribute("draggable", "true");
  todo_div.setAttribute("columna", json.column);
  if (!(todo_div.getAttribute("columna") === "columna_4")) {
    todo_div.setAttribute("id", json.idpostit);
    /* create span */
    const span = document.createElement("span");
    const span_txt = document.createTextNode("\u00D7");
    span.classList.add("close");
    //span.appendChild(span_txt);

    todo_div.appendChild(span);
    var col = document.getElementById(json.column);
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
setup();
function message(json) {
  stompClient.send("/topic/kanvan", {}, JSON.stringify(json));
}

/*--------------conexion base de datos--------------*/

function save(json) {
  var column = json.column;
  var idpostit = json.idpostit;
  var textopost = json.textopost;
  var propi = json.propi;
  var accion = 1;
}
