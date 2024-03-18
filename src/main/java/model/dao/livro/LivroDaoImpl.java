package model.dao.livro;

import model.entity.livro.Livro;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LivroDaoImpl implements LivroDao{

    private static LivroDaoImpl instance = null;
    private Set<Livro> conjunto;

    private LivroDaoImpl(){
        this.conjunto = new HashSet<>();
    }

    public static LivroDaoImpl getInstance(){
        if (instance == null){
            return new LivroDaoImpl();
        }
        return instance;
    }

    @Override
    public Set<Livro> getAll() {
        return conjunto;
    }

    @Override
    public boolean inserirLivro(Livro livro) {
        return conjunto.add(livro);
    }

    @Override
    public boolean removerLivro(Livro livro) {
        return conjunto.remove(livro);
    }
}
