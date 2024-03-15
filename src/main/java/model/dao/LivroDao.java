package model.dao;

import model.entity.livro.Livro;

import java.util.List;

public interface LivroDao {

    boolean inserirLivro();
    boolean removerLivro();
    List<Livro> getLivros();
}
