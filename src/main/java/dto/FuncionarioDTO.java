package dto;

import model.entity.user.Funcionario;
import model.entity.user.Usuario;

public class FuncionarioDTO implements IDTO<Usuario>{

    private String nome;
    private String email;
    private String telefone;

    public FuncionarioDTO(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public FuncionarioDTO(Usuario u){
        this.nome = u.getNome();
        this.email = u.getEmail();
        this.telefone = u.getTelefone();
    }

    @Override
    public Usuario toEntity() {
        return new Funcionario(nome,
                email,
                telefone);
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
}
