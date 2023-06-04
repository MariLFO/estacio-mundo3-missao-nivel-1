import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Pessoa Física
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        repo1.inserir(new PessoaFisica(1, "Ana", "11111111111", 25));
        repo1.inserir(new PessoaFisica(2, "Carlos", "22222222222", 52));
        try{
            repo1.persistir("pessoasFisicas.dat");
        }
        catch(IOException exception) {
            exception.printStackTrace();
        }
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        try {
            repo2.recuperar("pessoasFisicas.dat");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        for (PessoaFisica pessoaFisica : repo2.obterTodos()) {
            pessoaFisica.exibir();
        }
        // Pessoa Jurídica
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(new PessoaJuridica(3, "XPTO Sales", "33333333333333"));
        repo3.inserir(new PessoaJuridica(4, "XPTO Solutions", "44444444444444"));
        try{
            repo3.persistir("pessoasJuridicas.dat");
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        try {
            repo4.recuperar("pessoasJuridicas.dat");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        for (PessoaJuridica pessoaJuridica : repo4.obterTodos()) {
            pessoaJuridica.exibir();
        }
    }
}