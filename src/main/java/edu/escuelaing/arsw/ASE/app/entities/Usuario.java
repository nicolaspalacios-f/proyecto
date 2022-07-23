package edu.escuelaing.arsw.ASE.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombreUsuario", nullable = false)
    private String usuario;
    @Column(name = "claveUsuario", nullable = false)
    private String clave;

    public Usuario() {
    }

    /**
     * Constructor de la clase Usuario con nombre de usuario , id y clave
     * 
     * @param usuario: nombre del usuario
     * 
     * @param clave:   clave del usuario
     * 
     * @param id       id del usuario
     */
    public Usuario(long id, String usuario, String clave) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
    }

    /**
     * getter del id del usuario
     * 
     * @return id del usuario
     */
    public long getId() {
        return id;
    }

    /**
     * setter del id del usuario
     * 
     * @param id id del usuario
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * getter del nombre del usuario
     * 
     * @return nombre del usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * setter del nombre del usuario
     * 
     * @param usuario nombre del usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * getter de la clave del usuario
     * 
     * @return clave del usuario
     */
    public String getClave() {
        return clave;
    }

    /**
     * setter de la clave del usuario
     * 
     * @param clave clave del usuario
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

}
