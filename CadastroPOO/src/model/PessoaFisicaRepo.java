package model;

import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica>  pessoasFisicas;

    public void inserir(PessoaFisica entidade) {
        this.pessoasFisicas.add(entidade);
    }

    public void alterar(PessoaFisica entidade){
        this.excluir(entidade.id);
        this.inserir(entidade);
    }

    public void  excluir(int id){
        this.pessoasFisicas.removeIf(item -> item.id == id);
    }

    public ArrayList<PessoaFisica> obterTodos(){
        return this.pessoasFisicas;

    }
}
