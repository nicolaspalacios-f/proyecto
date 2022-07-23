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
import edu.escuelaing.arsw.ASE.app.entities.UsuarioXkanban;
import edu.escuelaing.arsw.ASE.app.repository.RepositoryKanban;
import edu.escuelaing.arsw.ASE.app.repository.RepositoryUsuario;
import edu.escuelaing.arsw.ASE.app.repository.RepositoryUsuarioXKanban;
import edu.escuelaing.arsw.ASE.app.services.ServicesUsuarioXKanban;

public class ServicesUsuarioXkanbanTest {

    @Mock
    private RepositoryKanban repoKanban;

    @Mock
    private RepositoryUsuario repoUsuario;

    @Mock
    private RepositoryUsuarioXKanban repoUsuarioXKanban;

    @InjectMocks
    private ServicesUsuarioXKanban servicesUsuarioXKanban;

    private Usuario usuario;
    private Usuario usuario2;
    private UsuarioXkanban usuarioXkanban;
    private UsuarioXkanban usuarioXkanban2;
    private Kanban kanban;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        usuario = new Usuario(Long.valueOf(0), "prueba", "prueba123");
        usuario2 = new Usuario(Long.valueOf(0), "prueba2", "prueba123");
        usuarioXkanban = new UsuarioXkanban(usuario, kanban);
        usuarioXkanban2 = new UsuarioXkanban(usuario2, kanban);

        kanban = new Kanban(Long.valueOf(0), "Prueba");

    }

    @Test // Test para crear un UsuarioXkanban
    void testCreate() {
        when(repoUsuarioXKanban.save(usuarioXkanban)).thenReturn(usuarioXkanban);
        assertTrue(servicesUsuarioXKanban.create(usuarioXkanban) != null);
    }

    @Test // Test para ver todos los Users
    void testGetAllUsers() {
        when(repoUsuarioXKanban.findAll()).thenReturn(Arrays.asList(usuarioXkanban, usuarioXkanban2));
        assertEquals(servicesUsuarioXKanban.findAll().size(), 2);

    }

    @Test // Test para ver un User por id
    void testGetUserById() {
        when(repoUsuarioXKanban.findById(Long.valueOf(0))).thenReturn(Optional.of(usuarioXkanban));
        assertEquals(servicesUsuarioXKanban.findById(Long.valueOf(0)).get(), usuarioXkanban);
    }

}
