package view.user;

import dto.UsuarioDTO;

import java.util.List;
import java.util.Scanner;

public class UsuarioView implements IUsuarioView{

    private static final Scanner input = new Scanner(System.in);

    @Override
    public UsuarioDTO cadastrarUsuario() {

        System.out.println("-----CADASTRO DE USUARIO-----");
        System.out.println("-----------------------------");

        System.out.print("Informe seu nome: ");
        String nome = input.nextLine();

        System.out.print("Informe seu email: ");
        String email = input.nextLine();

        System.out.print("Informe seu telefone: ");
        String telefone = input.nextLine();

        System.out.print("Informe seu cargo: ");
        String cargo = input.nextLine();

        return new UsuarioDTO(nome, email, telefone, cargo);
    }

    @Override
    public void listarPenalidades(List<UsuarioDTO> usuariosComPenalidade) {

        System.out.println("-----USUARIO(S) COM PENALIDADE-----");
        System.out.println("-----------------------------------");

        for (UsuarioDTO u : usuariosComPenalidade) {
            System.out.println(u.getNome());
        }
    }
}
