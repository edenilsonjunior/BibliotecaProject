package view.emprestimo;

import java.util.List;
import dto.LivroDTO;

public interface IEmprestimoView {
    
    String[] adicionarEmprestimo();
    void listarLivrosEmprestados(List<LivroDTO> livrosEmprestados);
    void listarEmprestimosAtrasados(String livrosAtrasados);
    void listarUsuariosComEmprestimos(List<String> usuariosComEmprestimos);
}
