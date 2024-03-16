package view.livro;

import dto.LivroDTO;

import java.util.List;
import java.util.Scanner;

public class LivroView implements ILivroView{

    private static final Scanner input = new Scanner(System.in);
    @Override
    public LivroDTO cadastrarLivro() {
        System.out.println("-----CADASTRO DE LIVROS-----");
        System.out.println("----------------------------");
        System.out.print("Informe o titulo do livro: ");
        var titulo = input.nextLine();
        System.out.println();
        System.out.print("Informe o autor do livro: ");
        var autor = input.nextLine();
        System.out.println();
        System.out.print("Informe a edicao do livro: ");
        var edicao = input.nextLine();
        System.out.println();
        return new LivroDTO(titulo,autor,edicao,true);
    }

    @Override
    public void listarLivros(List<LivroDTO> livros) {
        livros
                .forEach(livro ->{
                    System.out.println("----------------------------");
                    System.out.println("Titulo: " + livro.getTitulo());
                    System.out.println("Autor: " + livro.getAutor());
                    System.out.println("Edicao: " + livro.getEdicao());
                    System.out.println("----------------------------");
                });
    }

    @Override
    public void listarLivrosEmprestados(List<LivroDTO> livros) {
        livros.stream()
                .filter(livro -> !livro.isDisponivel())
                .forEach(livro -> {
                    System.out.println("----------------------------");
                    System.out.println("Titulo: " + livro.getTitulo());
                    System.out.println("Autor: " + livro.getAutor());
                    System.out.println("Edicao: " + livro.getEdicao());
                    System.out.println("----------------------------");
                });
    }
}
