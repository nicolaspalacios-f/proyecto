package edu.escuelaing.arsw.ASE.app.repository;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.escuelaing.arsw.ASE.app.entities.Postit;

@Repository
public interface RepositoryPostit extends JpaRepository<Postit, Long> {
    @Query("select c from Postit c where id_kanban=:id_kanban")
    Optional<Postit> getMaxId(@PathParam("id_kanban") Long id_kanban);
}
