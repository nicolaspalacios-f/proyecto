package edu.escuelaing.arsw.ASE.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.escuelaing.arsw.ASE.app.entities.UsuarioXkanban;

@Repository
public interface RepositoryUsuarioXKanban extends JpaRepository<UsuarioXkanban, Long> {
    @Query("select c from UsuarioXkanban c where id_kanban != :id_kanban")
    List<UsuarioXkanban> findAllnotParticipating(@Param("id_kanban") Long id_kanban);
}
