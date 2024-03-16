package model.entity.livro;

public class Livro {

    private String titulo;
    private String autor;
    private String edicao;
    private boolean disponivel;
    private int qntEmprestimo;

    public Livro(String titulo, String autor, String edicao, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.disponivel = disponivel;
        this.qntEmprestimo = 0;
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

    public void addQntEmprestado(){
        this.qntEmprestimo = this.qntEmprestimo +1;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int code = 17; //número primo inicial para evitar multiplicação por zero.
        code = prime * code + (titulo == null ? 0 : titulo.hashCode());
        code = prime * code + (autor == null ? 0 : autor.hashCode());
        code = prime * code + (edicao == null ? 0 : edicao.hashCode());
        return code;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Livro livro = (Livro) obj;
        return (this.getTitulo().equals(livro.getTitulo()) &&
                this.getEdicao().equals(livro.getEdicao()));
    }
}
