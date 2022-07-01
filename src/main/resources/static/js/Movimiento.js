import React, { useState } from "react";
import { DragDropContext, Droppable, Draggable } from "react-beautiful-dnd";
import uuid from "uuid/v4";

//2400;

class Movimiento extends React.Component {
  constructor(props) {
    super(props);
    const [columnas, setColumnas] = useState(columnasBack);
    const tareas = [
      //conectar con base de datos
      { id: uuid(), content: "poner 5" },
      { id: uuid(), content: "A nicolas palacios" },
    ];
    const columnasBack = {
      [uuid()]: { name: "Pendiente", items: tareas },
      [uuid()]: {
        name: "En proceso",
        items: [],
      },
    };
  }

  onDragEnd(result, columnas, setColumnas) {
    if (!result.destination) return;
    const { source, destination } = result;
    const columna = columnas[source.droppableId];
    const copiado = [...columna.items];
    const [removed] = copiado.splice(source.index, 1);
    copiado.splice(destination.index, o, removed);
    setColumnas({
      ...columnas,
      [source.droppableId]: {
        ...columna,
        items: copiado,
      },
    });
  }
  render() {
    return (
      <div className="app">
        <DragDropContext
          onDragEnd={(result) => onDragEnd(result, columnas, setColumnas)}
        >
          {Object.entries(columnas).map(([id, columna]) => {
            return (
              <div>
                <h2>{columna.name}</h2>
                <Droppable droppableId={id} key={id}>
                  {(prov, snap) => {
                    return (
                      <div
                        {...prov.droppableProps}
                        ref={prov.innerRef}
                        className="column"
                      >
                        {columna.items.map((item, index) => {
                          return (
                            <Draggable
                              key={items.id}
                              draggableId={item.id}
                              index={index}
                            >
                              {(prov, snap) => {
                                return (
                                  <div
                                    ref={prov.innerRef}
                                    {...prov.droppableProps}
                                    {...prov.dragHandleProps}
                                    className="post-it"
                                  >
                                    {item.content}
                                  </div>
                                );
                              }}
                            </Draggable>
                          );
                        })}
                        {provided.placeholder}
                      </div>
                    );
                  }}
                </Droppable>
              </div>
            );
          })}
        </DragDropContext>
      </div>
    );
  }
}
const rootElement = document.getElementById("kanva");
ReactDOM.render(<Movimiento />, rootElement);

// const postits = document.querySelectorAll(".postit");
// const todos = document.querySelectorAll(".column");
// let move = null;
// postits.forEach((postit) => {
//   postit.addEventListener("dragstart", dragStart);
//   postit.addEventListener("dragstart", dragEnd);
// });

// function dragStart() {
//   move = this;
//   console.log(move);
//   console.log("dragStart");
// }
// function dragEnd() {
//   move = null;
//   console.log("dragEnd");
// }

// todos.forEach((status) => {
//   status.addEventListener("dragover", dragOver);
//   status.addEventListener("dragover", dragEnter);
//   status.addEventListener("dragover", dragOut);
//   status.addEventListener("drop", drop);
// });

// function dragOver(e) {
//   e.preventDefault();
//   //console.log("dragover");
// }

// function dragEnter() {
//   console.log("dragEnter");
// }
// function dragOut() {
//   console.log("dragOut");
// }

// function drop() {
//   this.appendChild(move);
//   console.log("drop");
// }
