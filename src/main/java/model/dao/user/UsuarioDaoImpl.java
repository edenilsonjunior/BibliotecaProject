package model.dao.user;

import model.entity.user.Usuario;

import java.util.HashSet;
import java.util.Set;

public class UsuarioDaoImpl implements UsuarioDao {
    private Set<Usuario> usuarios;
    private static UsuarioDao instance = null;

    public UsuarioDaoImpl() {
        this.usuarios = new HashSet<>();
    }

    public static UsuarioDao getInstance() {
        if (instance == null) {
            instance = new UsuarioDaoImpl();
        }
        return instance;
    }

    @Override
    public Set<Usuario> getAll() {
        return usuarios;
    }

    @Override
    public boolean inserir(Usuario usuario) {
        return usuarios.add(usuario);
    }

    @Override
    public boolean remover(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.equals(usuario)) {
                usuarios.remove(u);
                return true;
            }
        }
        return false;
    }
}
