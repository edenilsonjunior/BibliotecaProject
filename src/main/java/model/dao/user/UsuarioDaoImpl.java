package model.dao.user;

import model.entity.user.Usuario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UsuarioDaoImpl implements UsuarioDao {

    private Map<String, Usuario> usuarios;
    private static UsuarioDao instance = null;

    private UsuarioDaoImpl() {
        this.usuarios = new HashMap<>();
    }

    public static UsuarioDao getInstance() {
        if (instance == null) {
            instance = new UsuarioDaoImpl();
        }
        return instance;
    }

    @Override
    public Map<String, Usuario> getAll() {
        return usuarios;
    }

    @Override
    public Usuario getByName(String nome){
        return usuarios.get(nome);
    }

    @Override
    public boolean inserirUsuario(Usuario usuario) {
        usuarios.put(usuario.getNome(), usuario);

        if (usuarios.containsKey(usuario.getNome())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removerUsuario(String usuario) {
        usuarios.remove(usuario);

        if (usuarios.containsKey(usuario)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Set<Usuario> listarUsuariosComPenalidade() {

        Set<Usuario> usuariosComPenalidade = new HashSet<>();

        for (Usuario u : usuarios.values()) {
            for (int i = 0; i < u.getEmprestimos().size(); i++) {
                if (u.getEmprestimos().get(i).isAtrasado()) {
                    usuariosComPenalidade.add(u);
                    break;
                }
            }
        }

        if (usuariosComPenalidade.isEmpty()) return null;
        
        return usuariosComPenalidade;
    }

    public Set<Usuario> listarUsuariosComLivrosEmprestados(){

        Set<Usuario> usuariosComLivrosEmprestados = new HashSet<>();

        for (Usuario u : usuarios.values()) {
            if (u.getEmprestimos().size() > 0) {
                usuariosComLivrosEmprestados.add(u);
            }
        }

        if (usuariosComLivrosEmprestados.isEmpty()) return null;

        return usuariosComLivrosEmprestados;

    }
}
