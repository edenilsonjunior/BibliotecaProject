package view.user;

import dto.UsuarioDTO;

import java.util.Scanner;

public class UsuarioView implements IUsuarioView{

    private static final Scanner input = new Scanner(System.in);
    @Override
    public UsuarioDTO cadastrarUsuario() {
        System.out.println("-----CADASTRO DE USUARIO-----");
        System.out.println("----------------------------");
        System.out.print("Informe seu nome: ");
        var nome = input.nextLine();
        System.out.println();
        System.out.print("Informe seu email: ");
        var email = input.nextLine();
        System.out.println();
        System.out.print("Informe seu telefone: ");
        var telefone = input.nextLine();
        System.out.println();
        System.out.print("Informe seu cargo: ");
        var cargo = input.nextLine();
        System.out.println();
        return new UsuarioDTO(nome,email,telefone,cargo);
    }
}
