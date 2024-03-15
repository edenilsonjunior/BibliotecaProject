package model.entity.user;

import java.util.ArrayList;
import java.util.List;

import model.entity.livro.Emprestimo;

public class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private List<Emprestimo> emprestimos;

    public Usuario(String nome, String email, String telefone, List<Emprestimo> emprestimos) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.emprestimos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
}
