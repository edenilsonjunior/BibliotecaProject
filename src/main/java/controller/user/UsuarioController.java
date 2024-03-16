package controller.user;

import model.dao.user.UsuarioDao;
import model.dao.user.UsuarioDaoImpl;
import model.entity.user.Usuario;
import view.user.IUsuarioView;
import view.user.UsuarioView;

public class UsuarioController {

    private IUsuarioView usuarioView;
    private UsuarioDao usuarioDao;

    public UsuarioController() {
        this.usuarioView = new UsuarioView();
        this.usuarioDao = new UsuarioDaoImpl();
    }

    public boolean cadastrarUsuario() {
        Usuario usuario = usuarioView.cadastrarUsuario().toEntity();
        return usuarioDao.inserirUsuario(usuario);
    }
}
