package model.dao.emprestimo;


import model.entity.livro.Emprestimo;

import java.util.Set;
import java.util.HashSet;

public class EmprestimoDaoImpl implements EmprestimoDao {

    private static EmprestimoDaoImpl instance = null;
    private Set<Emprestimo> conjunto;

    private EmprestimoDaoImpl() {
        this.conjunto = new HashSet<>();
    }

    public static EmprestimoDaoImpl getInstance(){

        if(instance == null){
            instance = new EmprestimoDaoImpl();
        }
        return instance;
    }

    @Override
    public Set<Emprestimo> getAll(){
        return conjunto;
    }

    @Override
    public boolean inserirEmprestimo(Emprestimo emprestimo) {
        return conjunto.add(emprestimo);
    }

    @Override
    public String listarEmprestados() {
        StringBuilder sb = new StringBuilder();

        sb.append("-----Livros Emprestados-----");
        for (var data : conjunto){

            if (!data.getLivro().isDisponivel()){
                sb.append(data.getLivro().getTitulo());
            }
            sb.append("------------");
        }

        return sb.toString();
    }

    @Override
    public String listarAtrasados() {
        StringBuilder sb = new StringBuilder();

        sb.append("-----Livros Atrasados-----");
        for (var data : conjunto){

            if (data.isAtrasado()){
                sb.append(data.getLivro().getTitulo());
            }
            sb.append("------------");
        }

        return sb.toString();
    }
}

