package controller.user;

import dto.UsuarioDTO;
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

    public boolean listarUsuariosComPenalidade() {

        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        for (Usuario u : usuarioDao.listarUsuariosComPenalidade()) {
            usuariosDTO.add(new UsuarioDTO(u));
        }

        if (usuariosDTO.isEmpty()) {
            return false;
        }
        else {
            usuarioView.listarUsuariosComPenalidade(usuariosDTO);
            return true;
        }
    }
}
