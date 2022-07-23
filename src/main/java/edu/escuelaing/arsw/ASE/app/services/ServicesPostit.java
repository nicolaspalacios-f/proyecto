package edu.escuelaing.arsw.ASE.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arsw.ASE.app.entities.Postit;
import edu.escuelaing.arsw.ASE.app.repository.RepositoryPostit;

@Service
public class ServicesPostit {
    @Autowired
    private RepositoryPostit repositoryPostit;

    /**
     * Metodo que permite crear un nuevo postit
     * 
     * @param Postit postit a crear
     * 
     * @return repositoryPostit.save(postit)
     */
    public Postit create(Postit Postit) {
        return repositoryPostit.save(Postit);
    }

    /**
     * Metodo que permite obtener todos los postit
     * 
     * @return repositoryPostit.findAll()
     */
    public List<Postit> findAll() {
        return repositoryPostit.findAll();
    }

    /**
     * Metodo que permite borrar un postit
     * 
     * @param Postit postit a borrar
     * 
     */
    public void delete(Postit Postit) {
        repositoryPostit.delete(Postit);
    }

    /**
     * Metodo que permite obtener un postit por su id
     * 
     * @param id id del postit
     * 
     * @return repositoryPostit.findById(id)
     */
    public Optional<Postit> findById(Long id) {
        return repositoryPostit.findById(id);
    }

    /**
     * Metodo que permite obtener todos los postit de un kanban por su id
     * 
     * @param id id del kanban
     * 
     * @return repositoryPostit.getAllByKanban(id)
     */
    public List<Postit> getAllByKanban(Long id) {
        return repositoryPostit.getAllByKanban(id);
    }
}
