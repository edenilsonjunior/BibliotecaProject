package model.dao.livro;

import model.entity.livro.Livro;

import java.util.HashMap;
import java.util.Map;

public class LivroDaoImpl implements LivroDao{

    private static LivroDaoImpl instance = null;
    private Map<String, Livro> livros;

    private LivroDaoImpl(){
        this.livros = new HashMap<>();
    }

    public static LivroDaoImpl getInstance(){
        if (instance == null){
            instance = new LivroDaoImpl();
        }
        return instance;
    }

    @Override
    public Map<String, Livro> getAll() {
        return livros;
    }

    @Override
    public Livro getByTitulo(String titulo){
        return livros.getOrDefault(titulo, new Livro("titulo", "titulo", "titulo", false));
    }

    @Override
    public boolean inserirLivro(Livro livro) {
        
        livros.put(livro.getTitulo(), livro);

        if (livros.containsKey(livro.getTitulo())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removerLivro(Livro livro) {
        livros.remove(livro.getTitulo());

        if (livros.containsKey(livro.getTitulo())) {
            return false;
        } else {
            return true;
        }
    }
}
