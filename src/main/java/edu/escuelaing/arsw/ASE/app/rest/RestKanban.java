package edu.escuelaing.arsw.ASE.app.rest;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import edu.escuelaing.arsw.ASE.app.entities.Kanban;
import edu.escuelaing.arsw.ASE.app.services.ServicesKanban;

public class RestKanban {
    @Autowired
    private ServicesKanban servicesKanban;

    @PostMapping("/create") // Crea un nuevo kanban
    private void setnombreKanban(@PathParam("nombre_kanban") String nombre_kanban) {
        Kanban kanban = new Kanban(nombre_kanban);
        servicesKanban.create(kanban);

    }
}
