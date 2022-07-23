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

    /**
     * Metodo que permite crear un nuevo usuario
     * 
     * @param Usuario usuario a crear
     * 
     * @return repositoryUsuario.save(usuario)
     */
    public Usuario create(Usuario Usuario) {
        return repositoryUsuario.save(Usuario);
    }

    /**
     * Metodo que permite obtener todos los usuario
     * 
     * @return repositoryUsuario.findAll()
     */
    public List<Usuario> findAll() {
        return repositoryUsuario.findAll();
    }

    /**
     * Metodo que permite borrar un usuario
     * 
     * @param Usuario usuario a borrar
     * 
     * @return repositoryUsuario.delete(usuario)
     */
    public void delete(Usuario Usuario) {
        repositoryUsuario.delete(Usuario);
    }

    /**
     * Metodo que permite obtener un usuario por su id
     * 
     * @param id id del usuario
     * 
     * @return repositoryUsuario.findById(id)
     */
    public Optional<Usuario> findById(Long id) {
        return repositoryUsuario.findById(id);
    }

    /**
     * Metodo que permite obtener un usuario por su nombre
     * 
     * @param username nombre del usuario
     * 
     * @param password contrasena del usuario
     * 
     * @return repositoryUsuario.getUsuarioPorNombre(username, password)
     */
    public Optional<Usuario> getUsuarioPorNombre(String username, String password) {
        return repositoryUsuario.getUsuarioPorNombre(username, password);
    }
}
