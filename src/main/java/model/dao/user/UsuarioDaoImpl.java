package model.dao.user;

import model.entity.user.Usuario;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UsuarioDaoImpl implements UsuarioDao {

    private Set<Usuario> usuarios;
    private static UsuarioDao instance = null;

    private UsuarioDaoImpl() {
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
    public boolean inserirUsuario(Usuario usuario) {
        return usuarios.add(usuario);
    }

    @Override
    public boolean removerUsuario(Usuario usuario) {
        return usuarios.remove(usuario);
    }
}
