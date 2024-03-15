package model.entity.user;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import model.entity.livro.Emprestimo;

@Data
public class Usuario {

    private String nome;
    private String email;
    private String telefone;
    private List<Emprestimo> emprestimos;

    public Usuario(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.emprestimos = new ArrayList<>();
    }

}
