import java.util.ArrayList;
import java.util.List;

import controller.SystemController;
import controller.emprestimo.EmprestimoController;
import model.dao.livro.LivroDao;
import model.dao.livro.LivroDaoImpl;
import model.entity.livro.Livro;
import view.emprestimo.EmprestimoView;

public class Main {
    public static void main(String[] args) {

        new SystemController().run();
    }

}