package view.sistema;

public enum MenuOption {
    CADASTRAR_USUARIO(1),
    LISTAR_USUARIO_COM_EMPRESTIMO(2),
    LISTAR_USUARIO_COM_PENALIDADE(3),
    CADASTRAR_LIVRO(4),
    LISTAR_LIVROS(5),
    LISTAR_LIVROS_EMPRESTADOS(6),
    LISTAR_EMPRESTIMOS_ATRASADOS(7),
    SAIR(0);

    private final int indice;

    MenuOption(int indice) {
        this.indice = indice;
    }

    public int getIndice() {
        return indice;
    }
}
