package model.dao.user;

import model.entity.user.Usuario;

import java.util.Map;
import java.util.Set;

public interface UsuarioDao {

    Map<String, Usuario> getAll();
    Usuario getByName(String nome);
    boolean inserirUsuario(Usuario usuario);
    boolean removerUsuario(String usuario);
    Set<Usuario> listarUsuariosComPenalidade();
    Set<Usuario> listarUsuariosComLivrosEmprestados();
}
