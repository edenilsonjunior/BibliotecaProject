package controller.livro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dto.LivroDTO;
import model.dao.emprestimo.EmprestimoDao;
import model.dao.emprestimo.EmprestimoDaoImpl;
import model.dao.livro.LivroDao;
import model.dao.livro.LivroDaoImpl;
import model.entity.livro.Emprestimo;
import model.entity.livro.Livro;
import view.livro.ILivroView;
import view.livro.LivroView;
import view.sistema.SistemaView;

public class LivroController {

    private EmprestimoDao emprestimos;
    private LivroDao livros;

    private ILivroView livroView;

    private String[] opcoes;

    public LivroController(){

        this.emprestimos = EmprestimoDaoImpl.getInstance();
        this.livros = LivroDaoImpl.getInstance();
        this.livroView = new LivroView();

        opcoes = new String[]{
            "Cadastrar livro",
            "Listar todos os livros",
            "Listar quantidade de vezes que cada livro foi emprestado",
            "Voltar"
        };
    }

    public void run(){
            
            String escolha;
    
            do {
                escolha = SistemaView.menu(opcoes);
    
                switch (escolha) {
    
                    case "Cadastrar livro":
                        cadastrarLivro();
                        break;
    
                    case "Listar todos os livros":
                        listarLivros();
                        break;
    
                    case "Listar quantidade de vezes que cada livro foi emprestado":
                        listarQntLivrosEmprestados();
                        break;
                }
    
            } while (!escolha.equals("Voltar"));
    }

    private void cadastrarLivro() {
        
        LivroDTO livro = livroView.cadastrarLivro();

        if (livros.inserirLivro(livro.toEntity())) {
            SistemaView.mensagem("Livro cadastrado com sucesso!");
        } else {
            SistemaView.mensagem("Erro ao cadastrar livro!");
        }

    }

    private void listarLivros() {

        Set<LivroDTO> livrosDto = new HashSet<>();
        
        for (Livro data : livros.getAll().values()){
            livrosDto.add(new LivroDTO(data));
        }

        if (livrosDto.isEmpty()) {
            
            SistemaView.mensagem("Nenhum livro cadastrado!");
        }
        else {
            livroView.listarLivros(livrosDto);
        }
    }

    private void listarQntLivrosEmprestados() {
        
        List<String> livrosEmprestados = new ArrayList<>();

        for (Emprestimo e : emprestimos.getAll()) {
            livrosEmprestados.add(e.getLivro().getTitulo());
        }
    
        if (livrosEmprestados.isEmpty()) {
            SistemaView.mensagem("Nenhum livro emprestado!");
        } 
        else {
            livroView.listarQntLivrosEmprestados(livrosEmprestados);
        }
    }
}

