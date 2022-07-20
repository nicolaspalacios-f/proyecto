package edu.escuelaing.arsw.ASE.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.escuelaing.arsw.ASE.app.entities.Kanban;

@Repository
public interface RepositoryKanban extends JpaRepository<Kanban, Long> {
    @Query("select c from Kanban c where nombre_kanban=:nombre")
    Optional<Kanban> findByName(@Param("nombre") String nombre);

}
