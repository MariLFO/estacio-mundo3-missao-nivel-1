package model;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private int idade;

    public PessoaFisica(int id, String nome, String cpf, int idade){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;

    }

    @Override
    public void exibir() {
        System.out.println("id: "+ this.id + ", nome: "+ this.nome + ", cpf: "+ this.cpf + ", idade: "+ this.idade);
    }


}
