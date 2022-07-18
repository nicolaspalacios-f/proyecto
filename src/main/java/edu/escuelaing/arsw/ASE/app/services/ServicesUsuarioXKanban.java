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

    public UsuarioXkanban create(UsuarioXkanban UsuarioXKanban) {
        return repositoryUsuarioXKanban.save(UsuarioXKanban);
    }

    public List<UsuarioXkanban> findAll() {
        return repositoryUsuarioXKanban.findAll();
    }

    public void delete(UsuarioXkanban UsuarioXKanban) {
        repositoryUsuarioXKanban.delete(UsuarioXKanban);
    }

    public Optional<UsuarioXkanban> findById(Long id) {
        return repositoryUsuarioXKanban.findById(id);
    }
}
