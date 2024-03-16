package model.dao.livro;


import model.entity.livro.Livro;

import java.util.List;

public interface LivroDao {

    boolean inserirLivro(Livro livro);
    boolean removerLivro(Livro livro);
    List<Livro> getLivros();
}
