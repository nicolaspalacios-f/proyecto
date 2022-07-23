package edu.escuelaing.arsw.ASE.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arsw.ASE.app.entities.Kanban;
import edu.escuelaing.arsw.ASE.app.repository.RepositoryKanban;

@Service
public class ServicesKanban {
    @Autowired
    private RepositoryKanban repositoryKanban;

    /**
     * Metodo que permite crear un nuevo kanban
     * 
     * @param kanban kanban a crear
     * 
     * @return repositoryKanban.save(kanban)
     */
    public Kanban create(Kanban kanban) {

        return repositoryKanban.save(kanban);
    }

    /**
     * Metodo que permite obtener todos los kanban
     * 
     * @return repositoryKanban.findAll()
     */
    public List<Kanban> findAll() {
        return repositoryKanban.findAll();
    }

    /**
     * Metodo que permite borrar un kanban
     * 
     * @param kanban kanban a borrar
     * 
     */
    public void delete(Kanban kanban) {
        repositoryKanban.delete(kanban);
    }

    /**
     * Metodo que permite obtener un kanban por su id
     * 
     * @param id id del kanban
     * 
     * @return repositoryKanban.findById(id)
     */
    public Optional<Kanban> findById(Long id) {
        return repositoryKanban.findById(id);
    }

    /**
     * Metodo que permite obtener un kanban por su nombre
     * 
     * @param nombre_kanban nombre del kanban
     * 
     * @return repositoryKanban.findByName(nombre_kanban)
     */
    public Optional<Kanban> findByName(String nombre_kanban) {
        return repositoryKanban.findByName(nombre_kanban);
    }

}
