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

    /**
     * Constructor de la clase Postit
     */
    public Postit() {
    }

    /**
     * Constructor de la clase Postit con informacion, idKanban, id y columna
     * 
     * @param informacion informacion del postit
     * 
     * @param idKanban    id del kanban
     * 
     * @param id          id del postit
     * 
     * @param columna     columna del postit
     */
    public Postit(long id, String columna, String informacion, Kanban idKanban) {
        this.id = id;
        this.columna = columna;
        this.informacion = informacion;
        this.idKanban = idKanban;
    }

    /**
     * Constructor de la clase postit con informacion, idKanban, id y columna
     * 
     * @param informacion informacion del postit
     * 
     * @param idKanban    id del kanban
     * 
     * @param columna     columna del postit
     */
    public Postit(String columna, String informacion, Kanban idKanban) {
        this.columna = columna;
        this.informacion = informacion;
        this.idKanban = idKanban;
    }

    /**
     * Getter del id del postit
     * 
     * @return id del postit
     */
    public long getId() {
        return id;
    }

    /**
     * Setter del id del postit
     * 
     * @param id id del postit
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter de la columna del postit
     * 
     * @return columna del postit
     */
    public String getColumna() {
        return columna;
    }

    /**
     * Setter de la columna del postit
     * 
     * @param columna columna del postit
     */
    public void setColumna(String columna) {
        this.columna = columna;
    }

    /**
     * Getter de la informacion del postit
     * 
     * @return informacion del postit
     */
    public String getInformacion() {
        return informacion;
    }

    /**
     * Setter de la informacion del postit
     * 
     * @param informacion informacion del postit
     */
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    /**
     * Getter del idKanban del postit
     * 
     * @return idKanban del postit
     */
    public Kanban getIdKanban() {
        return idKanban;
    }

    /**
     * Setter del idKanban del postit
     * 
     * @param idKanban idKanban del postit
     */
    public void setIdKanban(Kanban idKanban) {
        this.idKanban = idKanban;
    }

}
