package controller.emprestimo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dto.LivroDTO;
import model.dao.emprestimo.EmprestimoDao;
import model.dao.emprestimo.EmprestimoDaoImpl;
import model.dao.livro.LivroDao;
import model.dao.livro.LivroDaoImpl;
import model.dao.user.UsuarioDao;
import model.dao.user.UsuarioDaoImpl;
import model.entity.livro.Emprestimo;
import model.entity.livro.Livro;
import model.entity.user.Usuario;
import view.emprestimo.EmprestimoView;
import view.emprestimo.IEmprestimoView;
import view.sistema.SistemaView;

public class EmprestimoController {

    private UsuarioDao usuarios;
    private EmprestimoDao emprestimos;
    private LivroDao livros;

    private IEmprestimoView emprestimoView;

    private String[] opcoes;
    
    public EmprestimoController(){

        this.usuarios = UsuarioDaoImpl.getInstance();
        this.emprestimos = EmprestimoDaoImpl.getInstance();
        this.livros = LivroDaoImpl.getInstance();

        this.emprestimoView = new EmprestimoView();

        opcoes = new String[]{
            "Adicionar emprestimo",
            "Livros emprestados",
            "Emprestimos atrasados",
            "Usuarios com livros emprestados"
        };    
    }

    public void run(){

        String escolha;

        do {
            // SistemaView.limparTela();
            escolha = SistemaView.menu(opcoes);

            switch (escolha) {

                case "Adicionar emprestimo":
                    adicionarEmprestimo();
                    break;

                case "Livros emprestados":
                    listarLivrosEmprestados();
                    break;

                case "Emprestimos atrasados":
                    listarEmprestimosAtrasados();
                    break;

                case "Usuarios com livros emprestados":
                    listarUsuariosComLivrosEmprestados();
                    break;
                default:
                    SistemaView.mensagem("Opção inválida");
                    break;
            }

        } 
        while (!escolha.equals("Voltar"));

    }

    private void adicionarEmprestimo() {

        String[] dadosEmprestimo = emprestimoView.adicionarEmprestimo();

        Usuario usuario = usuarios.getByName(dadosEmprestimo[1]);
        Livro livro = livros.getByTitulo(dadosEmprestimo[0]);

        if (livro != null && usuario != null) {

            if (livro.isDisponivel()) {

                livro.setDisponivel(false);

                LocalDate dataEmprestimo = LocalDate.now();
                LocalDate dataVencimento = LocalDate.now().plusDays(7);

                Emprestimo emprestimo = new Emprestimo(usuario, livro, dataEmprestimo, dataVencimento);

                emprestimos.inserirEmprestimo(emprestimo);
                usuario.getEmprestimos().add(emprestimo);
                SistemaView.mensagem("Emprestimo realizado com sucesso");

            } 
            else {
                SistemaView.mensagem("Livro indisponível");
            }

        } else {
            SistemaView.mensagem("Livro ou usuário não encontrado");
        }
    }

    private void listarLivrosEmprestados() {
        List<LivroDTO> livrosEmprestados = new ArrayList<>();

        for (Livro livro : livros.getAll().values()) {

            if(!livro.isDisponivel()){
                livrosEmprestados.add(new LivroDTO(livro));
            }
        }

        if (livrosEmprestados.size() > 0) {
            emprestimoView.listarLivrosEmprestados(livrosEmprestados);
        } 
        else {
            SistemaView.mensagem("Nenhum livro emprestado");
        }
    }

    private void listarEmprestimosAtrasados() {

        String atrasados = emprestimos.listarAtrasados();
        emprestimoView.listarEmprestimosAtrasados(atrasados);
    }

    private void listarUsuariosComLivrosEmprestados() {
        Set<Usuario> usuariosComEmprestimos = usuarios.listarUsuariosComLivrosEmprestados();

        List<String> usuarios = new ArrayList<>();

        for (Usuario u : usuariosComEmprestimos) {
            usuarios.add(u.getNome());
        }
        
        if (usuariosComEmprestimos != null) {
            // emprestimoView.listarUsuariosComEmprestimos(usuarios);

            usuarios.forEach(a -> System.out.println(a));
        } 
        else {
            SistemaView.mensagem("Nenhum usuário com livros emprestados");
        }
    }
}