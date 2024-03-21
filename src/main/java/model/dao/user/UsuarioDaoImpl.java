package model.dao.user;

import model.entity.user.Usuario;

import java.util.HashSet;
import java.util.Objects;
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
    public boolean inserirUsuario(Usuario usuario) {
        return usuarios.add(usuario);
    }

    @Override
    public boolean removerUsuario(Usuario usuario) {
        return usuarios.remove(usuario);
    }

    @Override
    public Set<Usuario> listarUsuariosComPenalidade() {

        Set<Usuario> usuariosComPenalidade =  new HashSet<>();

        // teste
        Usuario uTeste = new Usuario("edcu","edcu@gmail.com", "190", "dev low code");

        for (Usuario u : usuarios) {
            for (var emprestimo : u.getEmprestimos()) {
                if (emprestimo.isAtrasado()) {
                    usuariosComPenalidade.add(u);
                    break;
                }
            }
        }

        // teste
        usuariosComPenalidade.add(uTeste);

        return usuariosComPenalidade;
    }
}
