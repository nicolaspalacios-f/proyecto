if(!sessionStorage.getItem("loggeado")){
    window.location.href = "index.html";
}


function darNombre(){
    const element =(
        <div>
            <h1>Bienvenido {sessionStorage.getItem("User")}!</h1>
        </div>
    )
    ReactDOM.render(element, document.getElementById('usuario'));
}
darNombre();