package edu.escuelaing.arsw.ASE.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arsw.ASE.app.entities.UsuarioXkanban;
import edu.escuelaing.arsw.ASE.app.repository.RepositoryUsuarioXKanban;

@Service
public class ServicesUsuarioXKanban {
    @Autowired
    private RepositoryUsuarioXKanban repositoryUsuarioXKanban;

    /**
     * Metodo que permite crear un nuevo usuarioxkanban
     * 
     * @param UsuarioXKanban usuarioxkanban a crear
     * 
     * @return repositoryUsuarioXKanban.save(usuarioxkanban)
     */
    public UsuarioXkanban create(UsuarioXkanban UsuarioXKanban) {
        return repositoryUsuarioXKanban.save(UsuarioXKanban);
    }

    /**
     * Metodo que permite obtener todos los usuarioxkanban
     * 
     * @return repositoryUsuarioXKanban.findAll()
     */
    public List<UsuarioXkanban> findAll() {
        return repositoryUsuarioXKanban.findAll();
    }

    /**
     * Metodo que permite borrar un usuarioxkanban
     * 
     * @param UsuarioXKanban usuarioxkanban a borrar
     * 
     */
    public void delete(UsuarioXkanban UsuarioXKanban) {
        repositoryUsuarioXKanban.delete(UsuarioXKanban);
    }

    /**
     * Metodo que permite obtener un usuarioxkanban por su id
     * 
     * @param id id del usuarioxkanban
     * 
     * @return repositoryUsuarioXKanban.findById(id)
     */
    public Optional<UsuarioXkanban> findById(Long id) {
        return repositoryUsuarioXKanban.findById(id);
    }
}
