package model;

public class Pessoa {
    protected int id;
    protected String nome;

    public Pessoa(){

    }
    public Pessoa(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    public void exibir() {
        System.out.println("id: "+ this.id + ", nome: "+ this.nome);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
