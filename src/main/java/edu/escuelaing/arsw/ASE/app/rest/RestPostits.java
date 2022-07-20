package edu.escuelaing.arsw.ASE.app.rest;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arsw.ASE.app.entities.Postit;
import edu.escuelaing.arsw.ASE.app.entities.Traductor;
import edu.escuelaing.arsw.ASE.app.services.ServicesKanban;
import edu.escuelaing.arsw.ASE.app.services.ServicesPostit;

@RestController
@RequestMapping("/api/postit")
public class RestPostits {
    @Autowired
    private ServicesPostit servicesPostit;
    @Autowired
    private ServicesKanban servicesKanban;

    @GetMapping("/getAllByKanban")
    private ResponseEntity<List<Postit>> getAllByKanban(@PathParam("id_kanban") String id_kanban) {
        Long id = Long.parseLong(id_kanban);
        List<Postit> usuario = servicesPostit.getAllByKanban(id);

        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/guardarEnBase")
    private ResponseEntity<Postit> guardarEnBase(@RequestBody Traductor postit) {
        Postit postit2 = new Postit(postit.getColumna(), postit.getInformacion(),
                servicesKanban.findById(postit.getIdKanban()).get());

        return ResponseEntity.ok(servicesPostit.create(postit2));
    }

    @PostMapping("/updateEnBase")
    private ResponseEntity<Postit> updateEnBase(@RequestBody Traductor postit) {

        Postit postit2 = new Postit(postit.getId(), postit.getColumna(), postit.getInformacion(),
                servicesKanban.findById(postit.getIdKanban()).get());

        return ResponseEntity.ok(servicesPostit.create(postit2));
    }

    @DeleteMapping("/eliminarEnBase")
    private void eliminarEnBase(@RequestBody Traductor postit) {
        Postit postit2 = new Postit(postit.getId(), postit.getColumna(), postit.getInformacion(),
                servicesKanban.findById(postit.getIdKanban()).get());
        servicesPostit.delete(postit2);

    }
}
