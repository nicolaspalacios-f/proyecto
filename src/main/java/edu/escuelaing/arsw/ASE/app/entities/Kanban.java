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

    public Kanban() {
    }

    public Kanban(String nombre_kanban) {
        this.nombre_kanban = nombre_kanban;
    }

    public Kanban(long id, String nombre_kanban) {
        this.id = id;
        this.nombre_kanban = nombre_kanban;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getnombre_kanban() {
        return nombre_kanban;
    }

    public void setnombre_kanban(String nombre_kanban) {
        this.nombre_kanban = nombre_kanban;
    }

}
