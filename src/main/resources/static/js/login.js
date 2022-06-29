var usuario = "admin";
var contrasena = "admin";
sessionStorage.setItem("loggeado",false);


function changeUrl(){
    if(usuario === document.getElementById("Usuario").value && contrasena === document.getElementById("Password").value){
        sessionStorage.setItem("loggeado",true);
        window.location.href="tablero.html"}
    else{
        alert("Datos erroneos");
    }
}
    
