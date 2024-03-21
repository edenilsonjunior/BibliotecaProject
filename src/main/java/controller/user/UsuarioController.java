package controller.user;

import model.dao.user.UsuarioDao;
import model.dao.user.UsuarioDaoImpl;
import model.entity.user.Usuario;
import view.user.IUsuarioView;
import view.user.UsuarioView;
import java.util.List;
import java.util.ArrayList;

public class UsuarioController {

    private IUsuarioView usuarioView;
    private UsuarioDao usuarioDao;

    public UsuarioController() {
        this.usuarioView = new UsuarioView();
        this.usuarioDao = UsuarioDaoImpl.getInstance();
    }

    public boolean cadastrarUsuario() {
        Usuario usuario = usuarioView.cadastrarUsuario().toEntity();
        return usuarioDao.inserirUsuario(usuario);
    }

    public List<String> listarPenalidades() {

        List<String> penalidades = new ArrayList<>(usuarioDao.getAll().size());

        StringBuilder sb = new StringBuilder();

        int i = 0;

        for (var user : usuarioDao.getAll()) {

            for (var emprestimo : user.getEmprestimos()) {
                if (emprestimo.isAtrasado()) {
                    String str = user.getNome();
                    penalidades.add(str);
                    break;
                }
            }
        }

        if (penalidades.isEmpty()) return null;

        return penalidades;
    }
}
