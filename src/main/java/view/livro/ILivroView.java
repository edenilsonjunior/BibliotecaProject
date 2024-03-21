package view.livro;

import java.util.List;
import dto.LivroDTO;

public interface ILivroView {
    LivroDTO cadastrarLivro();
    void listarLivros(List<LivroDTO> livros);
    void listarLivrosEmprestados(List<LivroDTO> livros);
}
