package edu.escuelaing.arsw.ASE.app;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.escuelaing.arsw.ASE.app.entities.Kanban;
import edu.escuelaing.arsw.ASE.app.entities.Postit;
import edu.escuelaing.arsw.ASE.app.repository.RepositoryPostit;
import edu.escuelaing.arsw.ASE.app.services.ServicesPostit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class ServicesPostitTest {

    @Mock
    private RepositoryPostit repoPostit;

    @InjectMocks
    private ServicesPostit servicesPostit;

    private Postit postit;
    private Postit postit2;
    private Kanban kanban;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        kanban = new Kanban(Long.valueOf(0), "Prueba");
        postit = new Postit(Long.valueOf(0), "columna_1", "prueba123", kanban);
        postit2 = new Postit(Long.valueOf(0), "columna_1", "prueba1234", kanban);
    }

    @Test // Test para crear un postit
    void testCreate() {
        when(repoPostit.save(postit)).thenReturn(postit);
        assertTrue(servicesPostit.create(postit) != null);
    }

    @Test // Test para ver todos los postit
    void testGetAllpostit() {
        when(repoPostit.findAll()).thenReturn(Arrays.asList(postit, postit2));
        assertEquals(servicesPostit.findAll().size(), 2);

    }

    @Test // Test para ver un postit por id
    void testGetpostitById() {
        when(repoPostit.findById(Long.valueOf(0))).thenReturn(Optional.of(postit));
        assertEquals(servicesPostit.findById(Long.valueOf(0)).get(), postit);
    }

}
