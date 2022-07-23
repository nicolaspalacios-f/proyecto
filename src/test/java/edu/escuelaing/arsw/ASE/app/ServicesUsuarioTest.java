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

import edu.escuelaing.arsw.ASE.app.entities.Usuario;
import edu.escuelaing.arsw.ASE.app.repository.RepositoryPostit;
import edu.escuelaing.arsw.ASE.app.repository.RepositoryUsuario;
import edu.escuelaing.arsw.ASE.app.services.ServicesUsuario;

public class ServicesUsuarioTest {

    @Mock
    private RepositoryPostit repoPostit;

    @Mock
    private RepositoryUsuario repoUsuario;

    @InjectMocks
    private ServicesUsuario servicesUsuario;

    private Usuario usuario;
    private Usuario usuario2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        usuario = new Usuario(Long.valueOf(0), "prueba", "prueba123");
        usuario2 = new Usuario(Long.valueOf(0), "prueba2", "prueba123");

    }

    @Test // Test para crear un Usuario
    void testCreate() {
        when(repoUsuario.save(usuario)).thenReturn(usuario);
        assertTrue(servicesUsuario.create(usuario) != null);
    }

    @Test // Test para ver todos los Users
    void testGetAllUsers() {
        when(repoUsuario.findAll()).thenReturn(Arrays.asList(usuario, usuario2));
        assertEquals(servicesUsuario.findAll().size(), 2);

    }

    @Test // Test para ver un User por id
    void testGetUserById() {
        when(repoUsuario.findById(Long.valueOf(0))).thenReturn(Optional.of(usuario));
        assertEquals(servicesUsuario.findById(Long.valueOf(0)).get(), usuario);
    }

    @Test // Test para ver un User por nombre y clave
    void testGetUsersByName() {
        when(repoUsuario.getUsuarioPorNombre("Prueba", "prueba123")).thenReturn(Optional.of(usuario));
        assertEquals(servicesUsuario.getUsuarioPorNombre("Prueba", "prueba123").get(), usuario);
    }

}
