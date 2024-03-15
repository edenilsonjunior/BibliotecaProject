package model.dao.user;

import model.entity.user.Usuario;

import java.util.Set;

public interface UsuarioDao {
    Set<Usuario> getAll();
    boolean inserir(Usuario usuario);
    boolean remover(Usuario usuario);
}
