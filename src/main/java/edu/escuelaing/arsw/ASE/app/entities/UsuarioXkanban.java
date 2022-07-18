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
    public manyMoto id;

    public UsuarioXkanban() {
    }

    public UsuarioXkanban(manyMoto id) {
        this.id = id;
    }

    public manyMoto getId() {
        return id;
    }

    public void setId(manyMoto id) {
        this.id = id;
    }

    public Usuario getIdUsuario() {
        return id.getIdUsuario();
    }

    public void setIdUsuario(Usuario usuario) {
        id.setIdUsuario(usuario);
    }

    public Kanban getIdKanban() {
        return id.getIdKanban();
    }

    public void setIdKanban(Kanban kanban) {
        id.setIdKanban(kanban);
    }

    public UsuarioXkanban(Usuario idUsuario, Kanban idKanban) {
        this.id = new manyMoto(idUsuario, idKanban);

    }

}

@Embeddable
class manyMoto implements Serializable {
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;
    @ManyToOne
    @JoinColumn(name = "idKanban", nullable = false)
    private Kanban idKanban;

    public manyMoto() {
    }

    public manyMoto(Usuario idUsuario, Kanban idKanban) {
        this.idUsuario = idUsuario;
        this.idKanban = idKanban;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Kanban getIdKanban() {
        return idKanban;
    }

    public void setIdKanban(Kanban idKanban) {
        this.idKanban = idKanban;
    }
}
