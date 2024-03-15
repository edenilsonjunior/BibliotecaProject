package model.dao.livro;


import model.entity.livro.Livro;

import java.util.List;

public interface LivroDao {

    boolean inserirLivro();
    boolean removerLivro();
    List<Livro> getLivros();
}
