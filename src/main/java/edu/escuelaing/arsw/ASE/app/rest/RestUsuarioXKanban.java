package edu.escuelaing.arsw.ASE.app.rest;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arsw.ASE.app.entities.Kanban;
import edu.escuelaing.arsw.ASE.app.entities.Traductor;
import edu.escuelaing.arsw.ASE.app.entities.Usuario;
import edu.escuelaing.arsw.ASE.app.entities.UsuarioXkanban;
import edu.escuelaing.arsw.ASE.app.services.ServicesKanban;
import edu.escuelaing.arsw.ASE.app.services.ServicesUsuario;
import edu.escuelaing.arsw.ASE.app.services.ServicesUsuarioXKanban;

@RestController
@RequestMapping("/api/usuariosxkanban")
public class RestUsuarioXKanban {
    @Autowired
    private ServicesUsuarioXKanban servicesUsuarioXKanban;
    @Autowired
    private ServicesUsuario servicesUsuario;
    @Autowired
    private ServicesKanban servicesKanban;

    @PostMapping("/crearUsuarioxKanban") // Crear un usuario en una columna de un kanban
    private ResponseEntity<UsuarioXkanban> crearUsuarioxKanban(@PathParam("id_usuario") Long id_usuario,
            @PathParam("id_kanban") Long id_kanban) {
        try {
            Usuario usuario = servicesUsuario.findById(id_usuario).get();
            Kanban kanban = servicesKanban.findById(id_kanban).get();
            UsuarioXkanban usuarioXkanban = new UsuarioXkanban(usuario, kanban);
            return ResponseEntity.ok(servicesUsuarioXKanban.create(usuarioXkanban));
        } catch (Exception e) {
            return ResponseEntity.ok(null);
        }

    }

    @GetMapping("/findAll") // Busca todos los kanbans
    private ResponseEntity<List<UsuarioXkanban>> findAll() {
        return ResponseEntity.ok(servicesUsuarioXKanban.findAll());
    }

}
