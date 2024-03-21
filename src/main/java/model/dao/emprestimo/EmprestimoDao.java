package model.dao.emprestimo;

import java.util.Set;

import model.entity.livro.Emprestimo;

public interface EmprestimoDao {

    Set<Emprestimo> getAll();
    boolean inserirEmprestimo(Emprestimo emprestimo);
    String listarEmprestados();
    String listarAtrasados();
}

