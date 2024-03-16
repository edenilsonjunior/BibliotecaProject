package model.entity.livro;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import model.entity.user.Usuario;

public class Emprestimo {

    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataVencimento;

    public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataVencimento) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataVencimento = dataVencimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isAtrasado(){

        Period periodo = Period.between(dataVencimento, LocalDate.now());

        int dias = periodo.getDays();

        return dias < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return Objects.equals(usuario, that.usuario) && Objects.equals(livro, that.livro) && Objects.equals(dataEmprestimo, that.dataEmprestimo) && Objects.equals(dataVencimento, that.dataVencimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, livro, dataEmprestimo, dataVencimento);
    }
}
