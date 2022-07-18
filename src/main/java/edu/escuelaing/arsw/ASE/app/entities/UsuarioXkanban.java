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

    public UsuarioXkanban() {
    }

    public UsuarioXkanban(ManyMoto id) {
        this.id = id;
    }

    public ManyMoto getId() {
        return id;
    }

    public void setId(ManyMoto id) {
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

    public ManyMoto() {
    }

    public ManyMoto(Usuario idUsuario, Kanban idKanban) {
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
