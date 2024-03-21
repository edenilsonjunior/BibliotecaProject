package model.dao.user;

import model.entity.user.Usuario;

import java.util.Set;

public interface UsuarioDao {

    Set<Usuario> getAll();
    boolean inserirUsuario(Usuario usuario);
    boolean removerUsuario(Usuario usuario);
    Set<Usuario> listarUsuarioComPenalidade();
}
