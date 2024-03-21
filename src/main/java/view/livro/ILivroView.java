package view.livro;

import java.util.List;
import java.util.Set;

import dto.LivroDTO;

public interface ILivroView {
    LivroDTO cadastrarLivro();
    void listarLivros(Set<LivroDTO> livros);
    void listarQntLivrosEmprestados(List<String> livrosEmprestados);
}
