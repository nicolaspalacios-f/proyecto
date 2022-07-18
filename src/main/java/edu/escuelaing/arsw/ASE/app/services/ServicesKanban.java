package edu.escuelaing.arsw.ASE.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arsw.ASE.app.entities.Kanban;
import edu.escuelaing.arsw.ASE.app.repository.RepositoryKanban;

@Service
public class ServicesKanban {
    @Autowired
    private RepositoryKanban repositoryKanban;

    public Kanban create(Kanban kanban) {
        return repositoryKanban.save(kanban);
    }

    public List<Kanban> findAll() {
        return repositoryKanban.findAll();
    }

    public void delete(Kanban kanban) {
        repositoryKanban.delete(kanban);
    }

    public Optional<Kanban> findById(Long id) {
        return repositoryKanban.findById(id);
    }
}
