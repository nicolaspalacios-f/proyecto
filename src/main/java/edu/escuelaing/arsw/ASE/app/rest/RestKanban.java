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

import edu.escuelaing.arsw.ASE.app.entities.Kanban;
import edu.escuelaing.arsw.ASE.app.services.ServicesKanban;

@RestController
@RequestMapping("/api/kanban")
public class RestKanban {
    @Autowired
    private ServicesKanban servicesKanban;

    /**
     * Metodo que permite crear un nuevo kanban
     * 
     * @param nombre_kanban nombre del kanban
     * 
     * @return ResponseEntity<Kanban>
     */
    @PostMapping("/create") // Crea un nuevo kanban
    private ResponseEntity<Kanban> setnombreKanban(@PathParam("nombre_kanban") String nombre_kanban) {
        Kanban kanban = new Kanban(nombre_kanban);
        return ResponseEntity.ok(servicesKanban.create(kanban));

    }

    /**
     * Metodo que permite obtener un kanban por su nombre
     * 
     * @param nombre_kanban nombre del kanban
     * 
     * @return ResponseEntity<Kanban>
     */
    @GetMapping("/findByName") // Busca un kanban por nombre
    private ResponseEntity<Optional<Kanban>> findByName(@PathParam("nombre_kanban") String nombre_kanban) {
        return ResponseEntity.ok(servicesKanban.findByName(nombre_kanban));
    }

    /**
     * Metodo que permite obtener todos los kanban
     * 
     * @return ResponseEntity<List<Kanban>>
     */
    @GetMapping("/findAll") // Busca todos los kanbans
    private ResponseEntity<List<Kanban>> findAll() {
        return ResponseEntity.ok(servicesKanban.findAll());
    }
}
