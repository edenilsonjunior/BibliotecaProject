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
            SistemaView.limparTela();

            escolha = SistemaView.menuSistema();

           switch (escolha){
                case MENU_USUARIO:
                    SistemaView.limparTela();
                    new UsuarioController().run();
                     break;
                case MENU_EMPRESTIMO:
                    SistemaView.limparTela();    
                    new EmprestimoController().run();    
                    break;
                case MENU_LIVRO:
                    SistemaView.limparTela();    
                    new LivroController().run();
                    break;
               default:
                    break;
           }

       } while(escolha != MenuOption.SAIR);
    }
}
