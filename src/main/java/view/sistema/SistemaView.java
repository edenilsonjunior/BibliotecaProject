package view.sistema;

import dto.UsuarioDTO;

import java.util.Scanner;

public class SistemaView {

    private final static Scanner input = new Scanner(System.in);

    public static MenuOption menu(){
        System.out.println("----------BIBLIOTECA IFSP----------");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Listar usuário com empréstimo");
        System.out.println("3. Listar usuário com penalidade");
        System.out.println("4. Cadastrar livro");
        System.out.println("5. Listar livros");
        System.out.println("6. Listar livros emprestados");
        System.out.println("7. Listar empréstimos atrasados");
        System.out.println("0. Sair");
        System.out.println("Digite a opção desejada: ");

        return switch (input.nextInt()) {
            case 1-> MenuOption.CADASTRAR_USUARIO;
            case 2-> MenuOption.LISTAR_USUARIO_COM_EMPRESTIMO;
            case 3-> MenuOption.LISTAR_USUARIO_COM_PENALIDADE;
            case 4-> MenuOption.CADASTRAR_LIVRO;
            case 5-> MenuOption.LISTAR_LIVROS;
            case 6-> MenuOption.LISTAR_LIVROS_EMPRESTADOS;
            case 7-> MenuOption.LISTAR_EMPRESTIMOS_ATRASADOS;
            default -> MenuOption.SAIR;
        };
    }

    public static void mensagemDeErro(String str) {
        System.out.println(str);
    }

    public static UsuarioDTO teste(){
        return new UsuarioDTO("henrique", "henrique@gmail.com", "1234324", "Funcionario");
    }
}
