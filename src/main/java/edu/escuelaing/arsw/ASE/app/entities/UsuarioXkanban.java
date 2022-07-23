package edu.escuelaing.arsw.ASE.app.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarioXkanban")
public class UsuarioXkanban {
    @EmbeddedId
    public ManyMoto id;

    /**
     * Constructor de la clase UsuarioXkanban
     */
    public UsuarioXkanban() {
    }

    /**
     * Constructor de la clase UsuarioXkanban con id
     * 
     * @param id: id del usuarioXkanban
     */
    public UsuarioXkanban(ManyMoto id) {
        this.id = id;
    }

    /**
     * Getter del id del usuarioXkanban
     * 
     * @return id del usuarioXkanban
     */
    public ManyMoto getId() {
        return id;
    }

    /**
     * Setter del id del usuarioXkanban
     * 
     * @param id: id del usuarioXkanban
     */
    public void setId(ManyMoto id) {
        this.id = id;
    }

    /**
     * Getter del id del usuarioXkanban
     * 
     * @return id del usuarioXkanban
     */
    public Usuario getIdUsuario() {
        return id.getIdUsuario();
    }

    /**
     * Setter del id del usuarioXkanban
     * 
     * @param usuario: usuario a asignar
     */
    public void setIdUsuario(Usuario usuario) {
        id.setIdUsuario(usuario);
    }

    /**
     * Getter del id del usuarioXkanban
     * 
     * @return id del usuarioXkanban
     */
    public Kanban getIdKanban() {
        return id.getIdKanban();
    }

    /**
     * Setter del id del usuarioXkanban
     * 
     * @param kanban: kanban a asignar en el usuarioXkanban
     */
    public void setIdKanban(Kanban kanban) {
        id.setIdKanban(kanban);
    }

    /**
     * Getter del id del usuarioXkanban
     * 
     * @param idUsuario: id del usuarioXkanban
     * 
     * @param idKanban:  id del kanban
     */
    public UsuarioXkanban(Usuario idUsuario, Kanban idKanban) {
        this.id = new ManyMoto(idUsuario, idKanban);

    }

}

@Embeddable
class ManyMoto implements Serializable {
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;
    @ManyToOne
    @JoinColumn(name = "idKanban", nullable = false)
    private Kanban idKanban;

    /**
     * Constructor de la clase ManyMoto
     */
    public ManyMoto() {
    }

    /**
     * Constructor de la clase ManyMoto con idUsuario y idKanban
     * 
     * @param idUsuario id del usuario
     * 
     * @param idKanban  id del kanban
     */
    public ManyMoto(Usuario idUsuario, Kanban idKanban) {
        this.idUsuario = idUsuario;
        this.idKanban = idKanban;
    }

    /**
     * Getter del id del usuario
     * 
     * @return id del usuario
     */
    public Usuario getIdUsuario() {
        return idUsuario;
    }

    /**
     * Setter del id del usuario
     * 
     * @param idUsuario id del usuario
     */
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Getter del id del kanban
     * 
     * @return id del kanban
     */
    public Kanban getIdKanban() {
        return idKanban;
    }

    /**
     * Setter del id del kanban
     * 
     * @param idKanban id del kanban
     */
    public void setIdKanban(Kanban idKanban) {
        this.idKanban = idKanban;
    }
}
