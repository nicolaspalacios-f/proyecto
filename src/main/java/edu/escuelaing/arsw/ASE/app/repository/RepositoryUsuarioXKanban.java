package edu.escuelaing.arsw.ASE.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.escuelaing.arsw.ASE.app.entities.UsuarioXkanban;

@Repository
public interface RepositoryUsuarioXKanban extends JpaRepository<UsuarioXkanban, Long> {

}
