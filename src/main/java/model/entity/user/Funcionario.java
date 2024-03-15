package model.entity.user;

import java.util.List;

import model.entity.livro.Emprestimo;

public class Funcionario extends Usuario {
    public Funcionario(String nome, String email, String telefone, List<Emprestimo> emprestimos) {
        super(nome, email, telefone, emprestimos);
    }
}
