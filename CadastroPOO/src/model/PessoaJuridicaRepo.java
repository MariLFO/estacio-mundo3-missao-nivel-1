package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

    public void persistir(String nomeArquivo) throws IOException {
        FileOutputStream fos = new FileOutputStream(nomeArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.pessoasJuridicas);
    }
}
