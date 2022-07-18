package edu.escuelaing.arsw.ASE.app.entities;

import javax.persistence.*;

@Entity
@Table(name = "postit")
public class Postit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "columna", nullable = false)
    private String columna;
    @Column(name = "informacion", nullable = true)
    private String informacion;
    @ManyToOne
    @JoinColumn(name = "idKanban", nullable = false)
    private Kanban idKanban;

    public Postit() {
    }

    public Postit(long id, String columna, String informacion, Kanban idKanban) {
        this.id = id;
        this.columna = columna;
        this.informacion = informacion;
        this.idKanban = idKanban;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public Kanban getIdKanban() {
        return idKanban;
    }

    public void setIdKanban(Kanban idKanban) {
        this.idKanban = idKanban;
    }

}
