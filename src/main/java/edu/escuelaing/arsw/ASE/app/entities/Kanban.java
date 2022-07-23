package edu.escuelaing.arsw.ASE.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

@Entity
@Table(name = "kanban")
public class Kanban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre_kanban", nullable = true)
    private String nombre_kanban;

    /**
     * Constructor de la clase Kanban
     * 
     * 
     */
    public Kanban() {
    }

    /**
     * Constructor de la clase Kanban con nombre del kanban
     * 
     * @param nombre_kanban nombre del kanban
     */
    public Kanban(String nombre_kanban) {
        this.nombre_kanban = nombre_kanban;
    }

    /**
     * Constructor de la clase Kanban con nombre del kanban e id
     * 
     * @param nombre_kanban nombre del kanban
     * 
     * @param id            id del kanban
     */
    public Kanban(long id, String nombre_kanban) {
        this.id = id;
        this.nombre_kanban = nombre_kanban;
    }

    /**
     * Getter del id del kanban
     * 
     * @return id del kanban
     */
    public long getId() {
        return id;
    }

    /**
     * Setter del id del kanban
     * 
     * @param id id del kanban
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter del nombre del kanban
     * 
     * @return nombre del kanban
     */
    public String getnombre_kanban() {
        return nombre_kanban;
    }

    /**
     * Setter del nombre del kanban
     * 
     * @param nombre_kanban nombre del kanban
     */
    public void setnombre_kanban(String nombre_kanban) {
        this.nombre_kanban = nombre_kanban;
    }

}
