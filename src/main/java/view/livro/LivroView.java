package view.livro;

import dto.LivroDTO;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LivroView implements ILivroView{

    private static final Scanner input = new Scanner(System.in);

    @Override
    public LivroDTO cadastrarLivro() {
        System.out.println("-----CADASTRO DE LIVROS-----");
        System.out.println("----------------------------");


        System.out.print("Informe o titulo do livro: ");
        String titulo = input.nextLine();

        System.out.print("Informe o autor do livro: ");
        String autor = input.nextLine();

        System.out.print("Informe a edicao do livro: ");
        String edicao = input.nextLine();

        return new LivroDTO(titulo,autor,edicao,true);
    }

    @Override
    public void listarLivros(Set<LivroDTO> livros) {
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
    public void listarQntLivrosEmprestados(List<String> livrosEmprestados) {
    
        int total = 0;
        for (String livro : livrosEmprestados) {
            System.out.println("----------------------------");
            System.out.println(total + ": " + livro);
            System.out.println("----------------------------");
            total++;
        }
    }
}
