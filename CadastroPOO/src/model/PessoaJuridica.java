package model;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {
    private String cnpj;

    public PessoaJuridica(int id, String nome, String cnpj){
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    @Override
    public void exibir() {
        System.out.println("id: "+ this.id + ", nome: "+ this.nome + ", cnpj: "+ this.cnpj);
    }
}

