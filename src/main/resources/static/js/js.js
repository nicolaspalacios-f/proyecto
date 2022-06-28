var stompClient;
function setup() {
    createCanvas(840, 680);
    stomp();
}
var colores = "#" + Math.floor(Math.random() * 16777215).toString(16);
function draw() {
    if (mouseIsPressed === true) {
        fill(colores);
        stroke(colores);
        ellipse(mouseX, mouseY, 5, 5);

        var json = {
            xPos: mouseX,
            yPos: mouseY,
            colorin: colores,
            borra: false,
        }
        sincro(json);
    }


}
function sincro(json) {
    stompClient.send("/topic/tablero", {}, JSON.stringify(json));
}
function colorSelector() {
    colores = document.getElementById("colour").value;
    console.log(colores);

}
function colorSelectorr(borrador) {
    colores = borrador;
    console.log(colores);

}
function borrare() {
    clear();
    var json = {
        borra: true,
    }
    sincro(json);

}
function stomp() {
    var socket = new SockJS("/stompEndpoint");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log(frame);
        stompClient.subscribe("/topic/tablero", function (event) {
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




