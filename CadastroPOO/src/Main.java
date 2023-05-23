import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(1, "João");
        p1.exibir();
        Pessoa p2 = new Pessoa(2, "Maria");
        p2.exibir();

        PessoaFisica pf= new PessoaFisica(3, "Laura", "000.000.000-00", 50);
        pf.exibir();

        PessoaJuridica pj= new PessoaJuridica(4,"Estácio de Sá", "01.024.763/0001-35");
        pj.exibir();
    }

}