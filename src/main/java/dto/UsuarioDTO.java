package dto;

import model.entity.user.Usuario;

public class UsuarioDTO implements IDTO<Usuario>{

    private String nome;
    private String email;
    private String telefone;
    private String cargo;

    public UsuarioDTO(String nome, String email, String telefone, String cargo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
    }

    public UsuarioDTO(Usuario u){
        this.nome = u.getNome();
        this.email = u.getEmail();
        this.telefone = u.getTelefone();
        this.cargo = u.getCargo();
    }

    @Override
    public Usuario toEntity() {
        return new Usuario(nome,
                email,
                telefone, cargo);
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
