package view.emprestimo;

import java.util.List;
import java.util.Scanner;

import dto.LivroDTO;

public class EmprestimoView implements IEmprestimoView{
    
    public String[] adicionarEmprestimo(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o nome do livro: ");
        String nomeLivro = scanner.nextLine();
        
        System.out.print("Digite o nome da pessoa: ");
        String nomePessoa = scanner.nextLine();

        // scanner.close();

        return new String[]{nomeLivro, nomePessoa};
    }

    @Override
    public void listarEmprestimosAtrasados(String livrosAtrasados) {
        System.out.println(livrosAtrasados);
    }

    @Override
    public void listarLivrosEmprestados(List<LivroDTO> livrosEmprestados) {
        System.out.println("Livros emprestados:");
        for (LivroDTO livro : livrosEmprestados) {
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("-----------------------------");
        }
    }

    @Override
    public void listarUsuariosComEmprestimos(List<String> usuariosComEmprestimos) {
        System.out.println("Usuários com empréstimos:");
        for (String usuario : usuariosComEmprestimos) {
            System.out.println("Nome: " + usuario);
            System.out.println("-----------------------------");
        }
    }


}
