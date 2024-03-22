package controller.user;

import java.util.ArrayList;
import java.util.List;

import dto.UsuarioDTO;
import model.dao.user.UsuarioDao;
import model.dao.user.UsuarioDaoImpl;
import model.entity.user.Usuario;
import view.sistema.SistemaView;
import view.user.IUsuarioView;
import view.user.UsuarioView;

public class UsuarioController {

    private IUsuarioView usuarioView;
    private UsuarioDao usuarioDao;
    private String[] opcoes;

    public UsuarioController() {
        this.usuarioView = new UsuarioView();
        this.usuarioDao = UsuarioDaoImpl.getInstance();

        opcoes = new String[]{
            "Cadastrar usuario",
            "Listar usuarios com penalidade"
        };
    }

    public void run() {

        String escolha;

        do {
            // SistemaView.limparTela();
            escolha = SistemaView.menu(opcoes);

            switch (escolha) {
                case "Cadastrar usuario":
                    cadastrarUsuario();
                    break;

                case "Listar usuarios com penalidade":
                    listarUsuariosComPenalidade();
                    break;
            }
        } while (!escolha.equals("Voltar"));
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
            usuarioView.listarPenalidades(usuariosDTO);
            return true;
        }
    }
}
