package edu.escuelaing.arsw.ASE.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.escuelaing.arsw.ASE.app.entities.Usuario;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {
    @Query("select c from Usuario c where nombre_usuario=:nombre and clave_usuario=:clave")
    Optional<Usuario> getUsuarioPorNombre(@Param("nombre") String nombre, @Param("clave") String clave);
}
