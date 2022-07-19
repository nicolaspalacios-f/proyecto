package edu.escuelaing.arsw.ASE.app.rest;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arsw.ASE.app.entities.Postit;

import edu.escuelaing.arsw.ASE.app.services.ServicesPostit;

@RestController
@RequestMapping("/api/postit")
public class RestPostits {
    @Autowired
    private ServicesPostit servicesPostit;

    @GetMapping("/id")
    private ResponseEntity<Optional<Postit>> getMaxId(@PathParam("id_kanban") Long id_kanban) {
        Optional<Postit> usuario = servicesPostit.getMaxId(id_kanban);
        return ResponseEntity.ok(usuario);
    }
}
