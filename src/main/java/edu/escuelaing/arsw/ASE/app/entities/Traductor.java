package edu.escuelaing.arsw.ASE.app.entities;

public class Traductor {

    private long id;
    private String columna;
    private String informacion;
    private long idKanban;

    public Traductor(long id, String columna, String informacion, long idKanban) {
        this.id = id;
        this.columna = columna;
        this.informacion = informacion;
        this.idKanban = idKanban;
    }

    public Traductor() {
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

    public long getIdKanban() {
        return idKanban;
    }

    public void setIdKanban(long idKanban) {
        this.idKanban = idKanban;
    }

}
