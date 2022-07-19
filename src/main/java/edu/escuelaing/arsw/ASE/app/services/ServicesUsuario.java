package edu.escuelaing.arsw.ASE.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arsw.ASE.app.entities.Usuario;
import edu.escuelaing.arsw.ASE.app.repository.RepositoryUsuario;

@Service
public class ServicesUsuario {
    @Autowired
    private RepositoryUsuario repositoryUsuario;

    public Usuario create(Usuario Usuario) {
        return repositoryUsuario.save(Usuario);
    }

    public List<Usuario> findAll() {
        return repositoryUsuario.findAll();
    }

    public void delete(Usuario Usuario) {
        repositoryUsuario.delete(Usuario);
    }

    public Optional<Usuario> findById(Long id) {
        return repositoryUsuario.findById(id);
    }

    public Optional<Usuario> getUsuarioPorNombre(String username, String password) {
        return repositoryUsuario.getUsuarioPorNombre(username, password);
    }
}
