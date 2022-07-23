package edu.escuelaing.arsw.ASE.app.rest;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arsw.ASE.app.entities.Usuario;
import edu.escuelaing.arsw.ASE.app.services.ServicesUsuario;

@RestController
@RequestMapping("/api/usuarios")
public class RestUsuarios {

    @Autowired
    private ServicesUsuario servicesUsuario;

    /**
     * Metodo que permite obtener un usuario por nombre de usuario
     * 
     * @param nombre_usuario nombre del usuario
     * 
     * @return ResponseEntity<Usuario>
     */
    @PostMapping("/login")
    private ResponseEntity<Optional<Usuario>> getUsuarioPorNombre(@PathParam("nombre_usuario") String nombre_usuario,
            @PathParam("clave_usuario") String clave_usuario) {
        Optional<Usuario> usuario = servicesUsuario.getUsuarioPorNombre(nombre_usuario, clave_usuario);
        return ResponseEntity.ok(usuario);
    }

    /**
     * Metodo que permite obtener todos los usuarios
     * 
     * @return ResponseEntity<List<Usuario>>
     */
    @GetMapping("/findAll")
    private ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(servicesUsuario.findAll());
    }

}
