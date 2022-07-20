sessionStorage.setItem("loggeado", false);

function changeUrl() {
  var usuario = document.getElementById("Usuario").value;
  var contrasena = document.getElementById("Password").value;
  fetch(
    "api/usuarios/login?nombre_usuario=" +
      usuario +
      "&clave_usuario=" +
      contrasena,
    { method: "POST" }
  )
    .then((data) => data.json())
    .then((data) => {
      if (data != null) {
        sessionStorage.setItem("loggeado", true);
        sessionStorage.setItem(
          "User",
          document.getElementById("Usuario").value
        );
        sessionStorage.setItem("id_usuario", data.id);

        window.location.href = "home.html";
      } else {
        alert("Datos erroneos");
      }
    });
}
