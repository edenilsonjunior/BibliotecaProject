package model.entity.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import model.dao.user.UsuarioDaoImpl;
import model.entity.livro.Emprestimo;

@Data
public class Usuario {

    private String nome;
    private String email;
    private String telefone;
    private String cargo;
    
    private List<Emprestimo> emprestimos;

    public Usuario(String nome, String email, String telefone, String cargo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.emprestimos = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(telefone, usuario.telefone) && Objects.equals(cargo, usuario.cargo) && Objects.equals(emprestimos, usuario.emprestimos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, telefone, cargo, emprestimos);
    }
}
