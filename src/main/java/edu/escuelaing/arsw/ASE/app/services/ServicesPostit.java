package edu.escuelaing.arsw.ASE.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arsw.ASE.app.entities.Postit;
import edu.escuelaing.arsw.ASE.app.repository.RepositoryPostit;

@Service
public class ServicesPostit {
    @Autowired
    private RepositoryPostit repositoryPostit;

    public Postit create(Postit Postit) {
        return repositoryPostit.save(Postit);
    }

    public List<Postit> findAll() {
        return repositoryPostit.findAll();
    }

    public void delete(Postit Postit) {
        repositoryPostit.delete(Postit);
    }

    public Optional<Postit> findById(Long id) {
        return repositoryPostit.findById(id);
    }
}
