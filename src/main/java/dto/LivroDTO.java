package dto;

import model.entity.livro.Livro;

public class LivroDTO implements IDTO<Livro>{
    private String titulo;
    private String autor;
    private String edicao;
    private boolean disponivel;
    private int qntEmprestimo;

    public LivroDTO(String titulo, String autor, String edicao, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.disponivel = disponivel;
    }

    public LivroDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.edicao = livro.getEdicao();
        this.disponivel = livro.isDisponivel();
        this.qntEmprestimo = livro.getQntEmprestimo();
    }

    @Override
    public Livro toEntity() {
        return new Livro(titulo, autor, edicao, disponivel);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getQntEmprestimo() {
        return qntEmprestimo;
    }

    public void setQntEmprestimo(int qntEmprestimo) {
        this.qntEmprestimo = qntEmprestimo;
    }
}
