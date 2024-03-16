package view.livro;

import java.util.List;

public interface ILivroView {
    LivroDTO cadastrarLivro();
    void listarLivros(List<LivroDTO> livros);
    void listarLivrosEmprestados(List<LivroDTO> livros);
}
