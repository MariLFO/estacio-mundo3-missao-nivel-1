import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
    private static PessoaJuridicaRepo repo2 = new PessoaJuridicaRepo();

    public static void main(String[] args) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo id");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Finalizar a execução");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    inserirPessoa();
                    break;
                case 2:
                    alterarPessoa();
                    break;
                case 3:
                    excluirPessoa();
                    break;
                case 4:
                    exibirPessoaPeloId();
                    break;
                case 5:
                    exibirTodasAsPessoas();
                    break;
                case 6:
                    salvarDados();
                    break;
                case 7:
                    recuperarDados();
            }

            System.out.println("-----------------------------------\n");
        }
    }

    private static String lerTipoDePessoa() {
        System.out.println("Escolha o tipo:\n\tPara Pessoa Física digite F\n\tPara Pessoa Jurídica digite J");
        String tipo = scanner.next();

        if (tipo.equalsIgnoreCase("F") || tipo.equalsIgnoreCase("J")) {
            return tipo;
        } else {
            System.out.println("Opção inválida, tente novamente.");
            return lerTipoDePessoa();
        }
    }

    private static PessoaFisica definirDadosPessoaFisica(PessoaFisica pessoaFisica) {
        try {
            System.out.println("Digite o id: ");
            pessoaFisica.setId(scanner.nextInt());
            System.out.println("Digite o nome: ");
            pessoaFisica.setNome(scanner.next());
            System.out.println("Digite o cpf: ");
            pessoaFisica.setCpf(scanner.next());
            System.out.println("Digite a idade: ");
            pessoaFisica.setIdade(scanner.nextInt());
            return pessoaFisica;
        } catch (Exception e) {
            System.out.println("Erro ao inserir os dados da Pessoa física:");
            e.printStackTrace();
            System.out.println("Por favor, tente novamente.");
            return null;
        }
    }

    private static PessoaJuridica definirDadosPessoaJuridica(PessoaJuridica pessoaJuridica) {
        try {
            System.out.println("Digite o id: ");
            pessoaJuridica.setId(scanner.nextInt());
            System.out.println("Digite o nome: ");
            pessoaJuridica.setNome(scanner.next());
            System.out.println("Digite o cnpj: ");
            pessoaJuridica.setCnpj(scanner.next());
            return pessoaJuridica;
        } catch (Exception e) {
            System.out.println("Erro ao inserir os dados da Pessoa Jurídica:");
            e.printStackTrace();
            System.out.println("Por favor, tente novamente.");
            return null;
        }
    }

    private static void lembreteSalvarDados() {
        System.out.println("Lembre-se de salvar os dados antes de finalizar a execução.");
    }

    private static void inserirPessoa() {
        String tipo = lerTipoDePessoa();

        if (tipo.equalsIgnoreCase("F")) {
            PessoaFisica pessoaFisica = definirDadosPessoaFisica(new PessoaFisica());
            if (pessoaFisica != null) {
                repo1.inserir(pessoaFisica);
                System.out.println("Pessoa Física incluída com sucesso.");
            }
        } else if (tipo.equalsIgnoreCase("J")) {
            PessoaJuridica pessoaJuridica = definirDadosPessoaJuridica(new PessoaJuridica());
            if (pessoaJuridica != null) {
                repo2.inserir(pessoaJuridica);
                System.out.println("Pessoa Jurídica incluída com sucesso.");
            }
        }

        lembreteSalvarDados();
    }

    private static void alterarPessoa() {
        String tipo = lerTipoDePessoa();

        if (tipo.equalsIgnoreCase("F")) {
            System.out.println("Digite o id da Pessoa Física que deseja alterar: ");
            int idPessoaFisica = scanner.nextInt();
            PessoaFisica pessoaFisica = repo1.obter(idPessoaFisica);
            if (pessoaFisica != null) {
                pessoaFisica.exibir();
                pessoaFisica = definirDadosPessoaFisica(pessoaFisica);
                if (pessoaFisica != null) {
                    System.out.println("Pessoa Física alterada com sucesso.");
                    repo1.alterar(pessoaFisica);
                }
            } else {
                System.out.println("Pessoa Física não encontrada.");
            }
        } else if (tipo.equalsIgnoreCase("J")) {
            System.out.println("Digite o id da Pessoa Jurídica que deseja alterar: ");
            int idPessoaJuridica = scanner.nextInt();
            PessoaJuridica pessoaJuridica = repo2.obter(idPessoaJuridica);
            if (pessoaJuridica != null) {
                pessoaJuridica.exibir();
                pessoaJuridica = definirDadosPessoaJuridica(pessoaJuridica);
                if (pessoaJuridica != null) {
                    repo2.alterar(pessoaJuridica);
                    System.out.println("Pessoa Jurídica alterada com sucesso.");
                }
            } else {
                System.out.println("Pessoa Jurídica não encontrada.");
            }
        }

        lembreteSalvarDados();
    }

    private static void excluirPessoa() {
        String tipo = lerTipoDePessoa();
        if (tipo.equalsIgnoreCase("F")) {
            System.out.println("Digite o id da Pessoa Física que deseja excluir: ");
            int idPessoaFisica = scanner.nextInt();
            PessoaFisica pessoaFisica = repo1.obter(idPessoaFisica);
            if (pessoaFisica != null) {
                repo1.excluir(idPessoaFisica);
                System.out.println("Pessoa Física excluída com sucesso.");
            } else {
                System.out.println("Pessoa Física não encontrada.");
            }
        } else if (tipo.equalsIgnoreCase("J")) {
            System.out.println("Digite o id da Pessoa Jurídica que deseja excluir: ");
            int idPessoaJuridica = scanner.nextInt();
            PessoaJuridica pessoaJuridica = repo2.obter(idPessoaJuridica);
            if (pessoaJuridica != null) {
                repo2.excluir(idPessoaJuridica);
                System.out.println("Pessoa Jurídica excluída com sucesso.");
            } else {
                System.out.println("Pessoa Jurídica não encontrada.");
            }
        }

        lembreteSalvarDados();
    }

    private static void exibirPessoaPeloId() {
        String tipo = lerTipoDePessoa();

        if (tipo.equalsIgnoreCase("F")) {
            System.out.println("Digite o id da Pessoa Física que deseja exibir: ");
            int idPessoaFisica = scanner.nextInt();
            PessoaFisica pessoaFisica = repo1.obter(idPessoaFisica);
            if (pessoaFisica != null) {
                pessoaFisica.exibir();
            } else {
                System.out.println("Pessoa Física não encontrada.");
            }
        } else if (tipo.equalsIgnoreCase("J")) {
            System.out.println("Digite o id da Pessoa Jurídica que deseja exibir: ");
            int idPessoaJuridica = scanner.nextInt();
            PessoaJuridica pessoaJuridica = repo2.obter(idPessoaJuridica);
            if (pessoaJuridica != null) {
                pessoaJuridica.exibir();
            } else {
                System.out.println("Pessoa Jurídica não encontrada.");
            }
        }
    }

    private static void exibirTodasAsPessoas() {
        String tipo = lerTipoDePessoa();

        if (tipo.equalsIgnoreCase("F")) {
            ArrayList<PessoaFisica> pessoasFisicas = repo1.obterTodos();
            if (pessoasFisicas != null) {
                System.out.println("Exibindo todos os registros de Pessoas Físicas:\n");
                for (PessoaFisica pessoaFisica : pessoasFisicas) {
                    pessoaFisica.exibir();
                }
            } else {
                System.out.println("Não existem Pessoas Físicas cadastradas.");
            }
        } else if (tipo.equalsIgnoreCase("J")) {
            ArrayList<PessoaJuridica> pessoasJuridicas = repo2.obterTodos();
            if (pessoasJuridicas != null) {
                System.out.println("Exibindo todos os registros de Pessoas Jurídicas.");
                for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
                    pessoaJuridica.exibir();
                }
            } else {
                System.out.println("Não existem Pessoas Jurídicas cadastradas.");
            }
        }
    }

    private static void salvarDados() {
        System.out.println("Digite o prefixo dos arquivos para salvar os dados: ");
        String nomeArquivo = scanner.next();

        try {
            String nomeArquivoPessoaFisica = nomeArquivo + ".fisica.bin";
            repo1.persistir(nomeArquivoPessoaFisica);
            System.out.println("Dados das Pessoas Físicas salvos com sucesso no arquivo " + nomeArquivoPessoaFisica + ".");
        } catch (IOException e) {
            System.out.println("Não foi possível salvar os dados das Pessoas Físicas.\nErro: " + e.getMessage());
        }

        try {
            String nomeArquivoPessoaJuridica = nomeArquivo + ".juridica.bin";
            repo2.persistir(nomeArquivoPessoaJuridica);
            System.out.println("Dados das Pessoas Jurídicas salvos com sucesso no arquivo " + nomeArquivoPessoaJuridica + ".");
        } catch (IOException e) {
            System.out.println("Não foi possível salvar os dados das Pessoas Jurídicas.\nErro: " + e.getMessage());
        }
    }

    private static void recuperarDados() {
        System.out.println("Digite o prefixo dos arquivos para salvar os dados: ");
        String nomeArquivo = scanner.next();

        try {
            String nomeArquivoPessoaFisica = nomeArquivo + ".fisica.bin";
            repo1.recuperar(nomeArquivoPessoaFisica);
            System.out.println("Pessoas Físicas recuperadas com sucesso do arquivo " + nomeArquivoPessoaFisica + ".");
        } catch (Exception e) {
            System.out.println("Erro ao recuperar Pessoas Físicas.\nErro: " + e.getMessage());
        }

        try {
            String nomeArquivoPessoaJuridica = nomeArquivo + ".juridica.bin";
            repo2.recuperar(nomeArquivoPessoaJuridica);
            System.out.println("Pessoas Jurídicas recuperadas com sucesso do arquivo " + nomeArquivoPessoaJuridica + ".");
        } catch (Exception e) {
            System.out.println("Erro ao recuperar Pessoas Jurídicas.\nErro: " + e.getMessage());
        }
    }
}
