package controller;

import controller.emprestimo.EmprestimoController;
import controller.livro.LivroController;
import controller.user.UsuarioController;
import view.sistema.MenuOption;
import view.sistema.SistemaView;

public class SystemController {

    public void run(){

       MenuOption escolha;

       do {
           escolha = SistemaView.menuSistema();

           switch (escolha){
                case MENU_USUARIO:
                    new UsuarioController().run();
                     break;
                case MENU_EMPRESTIMO:
                    new EmprestimoController().run();    
                    break;
                case MENU_LIVRO:
                    new LivroController().run();
                    break;
               default:
                    break;
           }

       } while(escolha != MenuOption.SAIR);
    }
}
