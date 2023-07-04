package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> pessoasJuridicas;

    public PessoaJuridicaRepo(){
        this.pessoasJuridicas = new ArrayList<PessoaJuridica>();
    }

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

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica item : this.pessoasJuridicas) {
            if (item.id == id) {
                return item;
            }
        }
        return null;
    }
    public ArrayList<PessoaJuridica> obterTodos(){
        return this.pessoasJuridicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        FileOutputStream fos = new FileOutputStream(nomeArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.pessoasJuridicas);
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(nomeArquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.pessoasJuridicas = (ArrayList<PessoaJuridica>) ois.readObject();
    }
}
