package edu.escuelaing.arsw.ASE.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.escuelaing.arsw.ASE.app.entities.Kanban;
import edu.escuelaing.arsw.ASE.app.entities.Usuario;
import edu.escuelaing.arsw.ASE.app.repository.RepositoryKanban;
import edu.escuelaing.arsw.ASE.app.repository.RepositoryPostit;
import edu.escuelaing.arsw.ASE.app.services.ServicesKanban;

public class ServicesKanbanTest {

    @Mock
    private RepositoryKanban repoKanban;

    @Mock
    private RepositoryPostit repoPostit;

    @InjectMocks
    private ServicesKanban servicesKanban;

    private Usuario usuario;
    private Kanban kanban;
    private Kanban kanban2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        usuario = new Usuario(Long.valueOf(0), "prueba", "prueba123");
        kanban = new Kanban(Long.valueOf(0), "Prueba");
        kanban2 = new Kanban(Long.valueOf(0), "Pruebaxd");
    }

    @Test // Test para crear un kanban
    void testCreate() {
        when(repoKanban.save(kanban)).thenReturn(kanban);
        assertTrue(servicesKanban.create(kanban) != null);
    }

    @Test // Test para ver todos los kanbans
    void testGetAllkanbans() {
        when(repoKanban.findAll()).thenReturn(Arrays.asList(kanban, kanban2));
        assertEquals(servicesKanban.findAll().size(), 2);

    }

    @Test // Test para ver un kanban por id
    void testGetKanbanById() {
        when(repoKanban.findById(Long.valueOf(0))).thenReturn(Optional.of(kanban));
        assertEquals(servicesKanban.findById(Long.valueOf(0)).get(), kanban);
    }

    @Test // Test para ver un kanban por nombre
    void testGetkanbanByName() {
        when(repoKanban.findByName("Prueba")).thenReturn(Optional.of(kanban));
        assertEquals(servicesKanban.findByName("Prueba").get(), kanban);
    }

}