const postits = document.querySelectorAll(".postit");
const todos = document.querySelectorAll(".column");
var datos = null;
let move = null;
postits.forEach((postit) => {
  postit.addEventListener("dragstart", dragStart);
  postit.addEventListener("dragend", dragEnd);
});

function dragStart() {
  move = this;
  console.log(move);
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
  move.setAttribute("columna", this.getAttribute("id"));
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

todo_submit.addEventListener("click", createTodo);

function createTodo() {
  const todo_div = document.createElement("div");
  const input_val = document.getElementById("todo_input").value;
  const txt = document.createTextNode(input_val);

  todo_div.appendChild(txt);
  todo_div.classList.add("post-it");
  todo_div.classList.add("postit");
  todo_div.setAttribute("draggable", "true");
  todo_div.setAttribute("columna", "columna_1");

  /* create span */
  const span = document.createElement("span");
  const span_txt = document.createTextNode("\u00D7");
  span.classList.add("close");
  span.appendChild(span_txt);

  todo_div.appendChild(span);
  columna_1.appendChild(todo_div);
  guardar(todo_div);
  span.addEventListener("click", () => {
    span.parentElement.style.display = "none";
  });

  todo_div.addEventListener("dragstart", dragStart);
  todo_div.addEventListener("dragend", dragEnd);

  document.getElementById("todo_input").value = "";
  todo_form.classList.remove("active");
  overlay.classList.remove("active");
  datos = todo_div;
  var json = {
    divHtml: datos,
    borra: false,
  };
  sincro(json);
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
  stompClient.send("/topic/kanvan", {}, JSON.stringify(json));
}

function borrare() {
  clear();
  var json = {
    borra: true,
  };
  sincro(json);
}
function stomp() {
  var socket = new SockJS("/stompEndpoint");
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
    console.log(frame);
    stompClient.subscribe("/topic/kanvan", function (event) {
      var json = JSON.parse(event.body);
      if (json.borra) {
        clear();
      } else {
        fill(json.colorin);
        stroke(json.colorin);
        ellipse(json.xPos, json.yPos, 7, 7);
      }
    });
  });
}

function message(json) {
  stompClient.send("/topic/tablero", {}, JSON.stringify(json));
}

/*--------------conexion base de datos--------------*/
function basedatos() {
  const todo_div = document.createElement("div");
  const input_val = "holiiiii";
  const txt = document.createTextNode(input_val);

  todo_div.appendChild(txt);
  todo_div.classList.add("post-it");
  todo_div.classList.add("postit");
  todo_div.setAttribute("draggable", "true");
  todo_div.setAttribute("columna", 1);

  /* create span */
  const span = document.createElement("span");
  const span_txt = document.createTextNode("\u00D7");
  span.classList.add("close");
  span.appendChild(span_txt);

  todo_div.appendChild(span);

  datos = todo_div;

  span.addEventListener("click", () => {
    span.parentElement.style.display = "none";
  });

  todo_div.addEventListener("dragstart", dragStart);
  todo_div.addEventListener("dragend", dragEnd);

  document.getElementById("todo_input").value = "";
  todo_form.classList.remove("active");
  overlay.classList.remove("active");
  console.log(datos);
}
function guardar(div) {
  console.log(div);
}
basedatos();
