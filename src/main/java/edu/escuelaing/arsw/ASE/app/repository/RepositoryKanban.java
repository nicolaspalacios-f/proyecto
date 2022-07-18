package edu.escuelaing.arsw.ASE.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.escuelaing.arsw.ASE.app.entities.Kanban;

@Repository
public interface RepositoryKanban extends JpaRepository<Kanban, Long> {

}
