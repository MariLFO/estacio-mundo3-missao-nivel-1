package model;

import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> pessoasJuridicas;

    public void inserir(PessoaJuridica entidade) {
        this.pessoasJuridicas.add(entidade);
    }

    public void alterar(PessoaJuridica entidade){
        this.excluir(entidade.id);
        this.inserir(entidade);
    }

    public void excluir(int id){
        this.pessoasJuridicas.removeIf(item -> item.id == id);
    }

    public ArrayList<PessoaJuridica> obterTodos(){
        return this.pessoasJuridicas;
    }
}
