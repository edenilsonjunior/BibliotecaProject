package model.dao.livro;

import model.entity.livro.Livro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LivroDaoImpl implements LivroDao{

    private static LivroDaoImpl instance = null;
    private Set<Livro> conjunto;

    public LivroDaoImpl(){
        this.conjunto = new HashSet<>();
    }

    public static LivroDaoImpl getInstance(){
        if (instance == null){
            return new LivroDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean inserirLivro(Livro livro) {
        return conjunto.add(livro);
    }

    @Override
    public boolean removerLivro(Livro livro) {
        return conjunto.remove(livro);
    }

    @Override
    public List<Livro> getLivros() {
        return null;
    }
}
