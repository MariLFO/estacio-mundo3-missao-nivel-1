package model;

import java.io.*;
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

    public void persistir(String nomeArquivo) throws IOException {
        FileOutputStream fos = new FileOutputStream(nomeArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.pessoasFisicas);
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(nomeArquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.pessoasFisicas = (ArrayList<PessoaFisica>) ois.readObject();
    }
}
