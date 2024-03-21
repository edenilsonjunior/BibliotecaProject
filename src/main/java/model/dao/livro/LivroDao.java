package model.dao.livro;


import model.entity.livro.Livro;

import java.util.Map;

public interface LivroDao {

    Map<String, Livro> getAll();
    Livro getByTitulo(String titulo);
    boolean inserirLivro(Livro livro);
    boolean removerLivro(Livro livro);
}
