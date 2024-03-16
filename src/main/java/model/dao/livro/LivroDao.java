package model.dao.livro;


import model.entity.livro.Livro;

import java.util.Set;

public interface LivroDao {

    Set<Livro> getAll();
    boolean inserirLivro(Livro livro);
    boolean removerLivro(Livro livro);
}
