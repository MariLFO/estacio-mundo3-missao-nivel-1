import model.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(1, "João");
        p1.exibir();
        Pessoa p2 = new Pessoa(2, "Maria");
        p2.exibir();

        p1.getId();
        p1.exibir();

        p1.getId();
        p1.exibir();

        p2.exibir();
    }

}