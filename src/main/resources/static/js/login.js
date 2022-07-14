var usuario = "admin";
var contrasena = "admin";
var usuario2 = "user";
var contrasena2 = "user";
sessionStorage.setItem("loggeado", false);

function changeUrl() {
  if (
    (usuario === document.getElementById("Usuario").value &&
      contrasena === document.getElementById("Password").value) ||
    (usuario2 === document.getElementById("Usuario").value &&
      contrasena2 === document.getElementById("Password").value)
  ) {
    sessionStorage.setItem("loggeado", true);
    sessionStorage.setItem("User", document.getElementById("Usuario").value);
    window.location.href = "home.html";
  } else {
    alert("Datos erroneos");
  }
}
