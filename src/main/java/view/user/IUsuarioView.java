package view.user;

import java.util.List;

import dto.UsuarioDTO;

public interface IUsuarioView {
    UsuarioDTO cadastrarUsuario();
    void listarUsuariosComPenalidade(List<UsuarioDTO> usuariosComPenalidade);
}
