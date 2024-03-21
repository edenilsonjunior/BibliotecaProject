package controller.sistema;

import controller.user.UsuarioController;
import dto.UsuarioDTO;
import model.dao.emprestimo.EmprestimoDao;
import model.dao.emprestimo.EmprestimoDaoImpl;
import model.dao.livro.LivroDao;
import model.dao.livro.LivroDaoImpl;
import model.dao.user.UsuarioDao;
import model.dao.user.UsuarioDaoImpl;
import model.entity.user.Usuario;
import view.sistema.MenuOption;
import view.sistema.SistemaView;

import java.awt.*;

public class SystemController {

    private UsuarioDao usuarios;
    private EmprestimoDao emprestimos;
    private LivroDao livros;
    private UsuarioController usuarioController;

    public SystemController() {
        usuarios = UsuarioDaoImpl.getInstance();
        livros = LivroDaoImpl.getInstance();
        emprestimos = EmprestimoDaoImpl.getInstance();
        usuarioController = new UsuarioController();
    }

    public void run(){

       MenuOption escolha;

       do {
           escolha = SistemaView.menu();

           switch (escolha){
               case CADASTRAR_LIVRO:
                   break;
               case CADASTRAR_USUARIO:
                   if (!usuarioController.cadastrarUsuario())
                       SistemaView.mensagemDeErro("Usuario Invalido");
                   break;
               case LISTAR_LIVROS:
                   break;
               case LISTAR_USUARIO_COM_EMPRESTIMO:
                   break;
               case LISTAR_EMPRESTIMOS_ATRASADOS:
                   break;
               case LISTAR_LIVROS_EMPRESTADOS:
                   break;
               case LISTAR_USUARIO_COM_PENALIDADE:
                    if (!usuarioController.listarUsuariosComPenalidade())
                       SistemaView.mensagemDeErro("Lista vazia");
               default:
                    break;
           }

       } while(escolha != MenuOption.SAIR);
    }
}
