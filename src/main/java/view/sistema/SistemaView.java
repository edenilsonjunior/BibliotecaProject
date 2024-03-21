package view.sistema;

import java.util.Scanner;

public class SistemaView {

    private final static Scanner input = new Scanner(System.in);

    public static MenuOption menuSistema(){
        System.out.println("----------BIBLIOTECA IFSP----------");
        System.out.println("1. Menu de usuário");
        System.out.println("2. Menu de empréstimo");
        System.out.println("3. Menu de livro");
        System.out.println("0. Sair");
        System.out.print("Digite a opção desejada: ");
        
        int escolha = input.nextInt();
        input.nextLine();

        return switch (escolha) {
            case 1-> MenuOption.MENU_USUARIO;
            case 2-> MenuOption.MENU_EMPRESTIMO;
            case 3-> MenuOption.MENU_LIVRO; 
            default -> MenuOption.SAIR;
        };
    }

    public static void mensagem(String str) {
        System.out.println(str);
    }

    public static String menu(String[] opcoes){
        System.out.println("----------BIBLIOTECA IFSP----------");
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println((i+1) + ". " + opcoes[i]);
        }
        System.out.println("0. Voltar");
        System.out.print("Digite a opção desejada: ");
        
        int escolha = input.nextInt();

        return escolha == 0 ? "Voltar" : opcoes[escolha-1];
    }

    public static void limparTela(){
    // Limpa a tela
    System.out.print("\033[H\033[2J");
    System.out.flush();
    }
}
