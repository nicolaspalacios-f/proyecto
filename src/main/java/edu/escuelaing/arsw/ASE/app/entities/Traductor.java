package edu.escuelaing.arsw.ASE.app.entities;

public class Traductor {

    private long id;
    private String columna;
    private String informacion;
    private long idKanban;

    /**
     * Constructor de la clase Traductor con informacion, idKanban, id y columna
     * 
     * @param informacion informacion del traductor
     * 
     * @param idKanban    id del kanban
     * 
     * @param id          id del traductor
     * 
     * @param columna     columna del traductor
     */
    public Traductor(long id, String columna, String informacion, long idKanban) {
        this.id = id;
        this.columna = columna;
        this.informacion = informacion;
        this.idKanban = idKanban;
    }

    /**
     * Constructor de la clase Traductor
     */
    public Traductor() {
    }

    /**
     * getter del id del traductor
     * 
     * @return id del traductor
     */
    public long getId() {
        return id;
    }

    /**
     * setter del id del traductor
     * 
     * @param id id del traductor
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * getter de la columna del traductor
     * 
     * @return columna del traductor
     */
    public String getColumna() {
        return columna;
    }

    /**
     * setter de la columna del traductor
     * 
     * @param columna columna del traductor
     */
    public void setColumna(String columna) {
        this.columna = columna;
    }

    /**
     * getter de la informacion del traductor
     * 
     * @return informacion del traductor
     */
    public String getInformacion() {
        return informacion;
    }

    /**
     * setter de la informacion del traductor
     * 
     * @param informacion informacion del traductor
     */
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    /**
     * getter del id del kanban
     * 
     * @return id del kanban
     */
    public long getIdKanban() {
        return idKanban;
    }

    /**
     * setter del id del kanban
     * 
     * @param idKanban id del kanban
     */
    public void setIdKanban(long idKanban) {
        this.idKanban = idKanban;
    }

}
